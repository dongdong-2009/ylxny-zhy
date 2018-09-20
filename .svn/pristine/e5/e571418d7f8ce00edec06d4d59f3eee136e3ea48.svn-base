package com.zhy.collector.conn.protocol.dlt;

import com.zhy.collector.conn.protocol.Protocol;
import com.zhy.collector.conn.protocol.ResultData;
import com.zhy.collector.util.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.data.protocol
 * @Description: DLT标准协议
 * @date Date : 2018年08月23日 14:20
 */
@Component
public class DLTProtocol extends Protocol<DLTFrameData> {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static byte START_FLAG = 0x68;
    public static byte END_FLAG = 0x16;
    public static int ADDRESS_BYTES_COUNT = 6;
    public static int C_CODE_INDEX = 8;
    public static int DATA_LENGTH_INDEX = 9;
    /**
     * 封装帧数据 返回字节数组（二进制数据流）
     */
    @Override
    public void encode(DLTFrameData data) {
        int capacity = data.getCapacity();
        ByteBuffer buffer = ByteBuffer.allocate(capacity);
        buffer.put(data.getFlag_start_1());
        buffer.put(data.getSubstation_addr());
        buffer.put(data.getFlag_start_2());
        buffer.put(data.getControl_code());
        buffer.put(data.getData_area_length());
        buffer.put(data.getData_area());
        buffer.put(data.getCs_code());
        buffer.put(data.getFlag_end_1());
        data.setFrameBytes(buffer.array());
    }

    /**
     * 读取帧数据 设置帧数据对象属性
     */
    @Override
    public void decode(DLTFrameData data) {
        try {
            byte[] dataBytes = data.getFrameBytes();
            if(dataBytes.length <= DLTFrameData.FRAME_BASIC_LENGTH){
                throw new Exception("不是完整的数据帧！");
            }
            if(!matchProtocol(dataBytes)){
                logger.info("接收到错误的DLT数据帧："+ DataUtil.conver2HexStr(dataBytes));
                return;
            }
            int index = 0;
            for(int i = 0; i < 3; i++){
                if(dataBytes[i] == ((byte)0xFE)){
                    index++;
                }
            }
            byte flag_start_1 = dataBytes[index];
            data.setFlag_start_1(flag_start_1);
            index++;
            byte[] substation_addr = new byte[6];
            for(int i = 0; i < DLTFrameData.FRAME_ADDRESS_LENGTH; i++){
                substation_addr[i] = dataBytes[i+index];
            }
            data.setSubstation_addr(substation_addr);
            index+=DLTFrameData.FRAME_ADDRESS_LENGTH;
            byte flag_start_2 = dataBytes[index];
            data.setFlag_start_2(flag_start_2);
            index++;
            byte control_code = dataBytes[index];
            data.setControl_code(control_code);
            index++;
            byte data_length = dataBytes[index];
            data.setData_area_length(data_length);
            index++;
            byte[] data_area = new byte[data_length];
            byte[] flag_bytes = new byte[4];
            int data_flag = 0;
            byte[] main_data = new byte[data_length-4];
            for(int i = 0; i < data_length; i++){
                //十进制做减33处理
                int resuult = (dataBytes[i+index] & 0xFF) - 0x33;
                if(i <= 3){
                    //数据域标识
                    flag_bytes[i] = (byte) resuult;
                }else{
                    //主数据
                    main_data[i-4] = (byte) Integer.parseInt(Integer.toHexString(resuult));
                }
            }
            data_flag = ((flag_bytes[0] <<24) & 0xFF000000)
                        +((flag_bytes[1] <<16) & 0x00FF0000)
                        +((flag_bytes[2] <<8) & 0x0000FF00)
                        +(flag_bytes[3] & 0x000000FF);
            data.setData_area_flag(data_flag);
            data.setMain_data(main_data);
            data.setData_area(data_area);
            index+=data_length;
            byte cs_code = dataBytes[index];
            data.setCs_code(cs_code);
            index++;
            byte flag_end = dataBytes[index];
            data.setFlag_end_1(flag_end);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /***
     * 对协议指令进行分发
     * @param data
     */
    @Override
    public void dispatch(DLTFrameData data) {
        int code = data.getControl_code();
        long flag = data.getData_area_flag();
        byte[] main_data = data.getMain_data();
        if(main_data.length == 0){
            return;
        }
        double e_data = conver2Double(main_data);
        if(DLTCMDCode.FUNCTION_CODE_RESP_POSITIVE_POWER.match(code,flag)){
            DecimalFormat format = new DecimalFormat();
            System.out.println("正向总功总电能："+e_data+" kWh");
        }else if(DLTCMDCode.FUNCTION_CODE_RESP_REVERSE_POWER.match(code,flag)){
            System.out.println("反向总功总电能："+e_data+" kWh");
        }else if(DLTCMDCode.FUNCTION_CODE_RESP_POSITIVE_POWERLESS.match(code,flag)){
            System.out.println("正向无功总电能："+e_data+" kvarh");
        }else if(DLTCMDCode.FUNCTION_CODE_RESP_REVERSE_POWERLESS.match(code,flag)){
            System.out.println("反向无功总电能："+e_data+" kvarh");
        }else if(DLTCMDCode.FUNCTION_CODE_RESP_A_VOLTAGE.match(code,flag)){
            e_data = conver2Double(main_data, "XXX.X");
            System.out.println("A相电压："+e_data+" V");
        }else if(DLTCMDCode.FUNCTION_CODE_RESP_A_CURRRENT.match(code,flag)){
            e_data = conver2Double(main_data, "XXX.XXX");
            System.out.println("A相电流："+e_data+" A");
        }else if(DLTCMDCode.FUNCTION_CODE_RESP_INSTANTE_POWER.match(code,flag)){
            System.out.println("瞬时有功功率："+e_data+" kWh");
        }else if(DLTCMDCode.FUNCTION_CODE_RESP_INSTANCE_POWERLESS.match(code,flag)){
            System.out.println("瞬时无功功率："+e_data+" kvarh");
        }else if(DLTCMDCode.FUNCTION_CODE_RESP_INSTANCE_TOTAL_POWER.match(code,flag)){
            System.out.println("总功率因素："+e_data);
        }else if(DLTCMDCode.FUNCTION_CODE_RESP_POSITIVE_POWER.match(code,flag)){
            System.out.println("瞬时总视在总功率："+e_data+" kWA");
        }
    }

    /**
     * 十进制
     * @param data
     * @return
     */
    private double conver2Double(byte[] data, String format) {
        StringBuffer s = new StringBuffer();
        for (int i = data.length; i > 0 ; i--)
        {
            s.append(DataUtil.conver2HexStr(data[i-1]));
        }
        int precision = 1;
        if(format.indexOf(".")!=-1){
            int length = format.substring(format.indexOf("."),format.length()-1).length();
            for(int i = 0 ; i < length; i++){
                precision *= 10;
            }
        }
        return Double.parseDouble(s.toString())/precision;
    }

    /**
     * 十进制
     * @param data
     * @return
     */
    private double conver2Double(byte[] data) {
        StringBuffer s = new StringBuffer();
        for (int i = data.length; i > 0 ; i--)
        {
            s.append(data[i-1]==0 ? "00" :data[i-1]);
        }
        return Double.parseDouble(s.toString())/2;
    }

    @Override
    protected boolean patternMatch(byte[] data) {
        if(data.length == 0){
            return false;
        }
        StringBuffer s = new StringBuffer();
        for(int i = 0 ; i < data.length; i++){
            String hexStr = data[i] == 0 ? "00" :Integer.toHexString(data[i] & 0xFF);
            s.append(hexStr.length() == 1 ? "0"+hexStr : hexStr);
        }
        String regex = "^fe68[0-9a-f]{12}68([0-9a-f][0-9a-f]){7,}16";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s.toString());
        return matcher.matches();
    }

    //验证校验码
    @Override
    protected boolean validate(byte[] frameBytes) {
        int length = frameBytes.length - 2;
        byte[] b = new byte[length];
        for(int i = 0 ; i < b.length; i++){
            b[i] = frameBytes[i];
        }
        byte cs_code = DataUtil.getCs_code(b);
        if((cs_code & 0xFF) == frameBytes[length]){
            return true;
        }
        return false;
    }

    @Override
    public int getProtocolType() {
        return Protocol.PROTOCOL_TYPE_DLT645;
    }

    @Override
    public List<ResultData> getResultData(byte[] data) {
        int index = 1;
        StringBuffer addrBuffer = new StringBuffer();
        for(int i = 0; i < ADDRESS_BYTES_COUNT; i++){
            byte b = data[index+ADDRESS_BYTES_COUNT - 1 - i];
            if(b==0 && i < 2){
                continue;
            }
            addrBuffer.append(DataUtil.conver2HexStr(b));
        }
        String c_code = DataUtil.conver2HexStr(data[C_CODE_INDEX]);
        byte data_length = data[DATA_LENGTH_INDEX];
        byte[] main_data = new byte[data_length-4];
        StringBuffer cmdBuffer = new StringBuffer();
        for(int i = 0; i < data_length; i++){
            //十进制做减33处理
            byte resuult = (byte)((data[i+DATA_LENGTH_INDEX] & 0xFF) - 0x33);
            if(i <= data_length - 1){
                //数据域标识
                cmdBuffer.append(DataUtil.conver2HexStr(resuult));
                if(i == data_length - 1){
                    cmdBuffer.append(" ");
                }
            }else{
                //主数据
                main_data[i-4] = resuult;
            }
        }
        StringBuffer dataBuffer = new StringBuffer();
        int length = main_data.length;
        for(int i = 0 ; i < main_data.length; i++){
            dataBuffer.append(DataUtil.conver2HexStr(main_data[length-1-i]));
        }
        List<ResultData> list = new ArrayList<ResultData>();
        ResultData result = new ResultData();
        result.setProtocol(getProtocolType());
        result.setCmd_type(c_code);
        result.setCmd(cmdBuffer.toString());
        result.setData(dataBuffer.toString());
        result.setAddress(addrBuffer.toString());
        list.add(result);
        return list;
    }

}
