package com.zhy.collector.conn.protocol.modbus;


import com.zhy.collector.conn.protocol.Protocol;
import com.zhy.collector.conn.protocol.ResultData;
import com.zhy.collector.util.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.conn.protocol.modbus
 * @Description: modbus协议
 * @date Date : 2018年08月28日 10:26
 */
@Component
public class ModbusProtocol extends Protocol<ModbusFrameData> {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //最基本的数据返回长度
    private int basic_resp_length = 7;

    @Override
    public void encode(ModbusFrameData data) {
        ByteBuffer buffer = ByteBuffer.allocate(data.getCapacity());
        buffer.put(data.getAddr_code());
        buffer.put(data.getFunc_code());
        buffer.put(data.getStart_addr());
        buffer.put(data.getData_num());
        buffer.put(data.getCrc_code());
        data.setFrameBytes(buffer.array());
    }

    @Override
    public void decode(ModbusFrameData data) {
        byte[] dataBytes = data.getFrameBytes();
        if(dataBytes.length < basic_resp_length){
            try {
                throw new Exception("不是完整的数据帧！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!matchProtocol(dataBytes)){
            logger.info("接收到错误的modbus数据帧："+ DataUtil.conver2HexStr(dataBytes));
            return;
        }
        byte[] frameBytes = data.getFrameBytes();
        int index = 0;
        byte addr_code = frameBytes[index];
        index++;
        data.setAddr_code(addr_code);
        byte func_code = frameBytes[index];
        data.setFunc_code(func_code);
        index++;
        byte data_area_length = frameBytes[index];
        data.setData_area_length(data_area_length);
        index++;
        byte[] data_area = new byte[data_area_length];
        for(int i = 0 ; i < data_area_length; i++){
            data_area[i] = frameBytes[index];
            index++;
        }
        data.setData_area(data_area);
        byte[] crc_code = new byte[2];
        for(int i = 0 ; i < data_area_length; i++){
            crc_code[i] = frameBytes[index];
            index++;
        }
        data.setCrc_code(crc_code);
    }

    @Override
    public void dispatch(ModbusFrameData data) {
        int code = data.getFunc_code();
        byte[] main_data = data.getData_area();
        int num = ((main_data[0] << 8) & 0xFF00) + ((main_data[1] & 0x00FF));
        if(ModbusCMDCode.CRC_CMD_READ_CRC.getCode() == code){
            System.out.println("读取读数："+num);
        }
    }

    @Override
    protected boolean patternMatch(byte[] data) {
        //1.基本长度判断
        if(data.length < basic_resp_length){
            return false;
        }
        //2.数据域必须是2的倍数
        if((data.length - basic_resp_length)/2 != 0){
            return false;
        }
        StringBuffer s = new StringBuffer();
        for(int i = 0 ; i < data.length; i++){
            String hexStr = data[i] == 0 ? "00" :Integer.toHexString(data[i] & 0xFF);
            s.append(hexStr.length() == 1 ? "0"+hexStr : hexStr);
        }
        String regex = "[0-9a-f]{14,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s.toString());
        return matcher.matches();
    }

    @Override
    protected boolean validate(byte[] data) {
        int length = data.length - 2;
        byte[] b = new byte[length];
        for(int i = 0 ; i < b.length; i++){
            b[i] = data[i];
        }
        String cs_code = DataUtil.getCrc16(b);
        System.out.println("cs code : "+cs_code);
        StringBuffer s = new StringBuffer();
        String cs1 = data[length] == 0 ? "00" :Integer.toHexString(data[length] & 0xFF);
        s.append(cs1.length() == 1 ? "0"+cs1 : cs1);
        String cs2 = data[length] == 0 ? "00" :Integer.toHexString(data[length+1] & 0xFF);
        s.append(cs2.length() == 1 ? "0"+cs2 : cs2);
        System.out.println(" return cs code : "+s.toString());
        if(s.toString().equals(cs_code)){
            return true;
        }
        return false;
    }

    @Override
    public int getProtocolType() {
        return Protocol.PROTOCOL_TYPE_MODBUS;
    }

    @Override
    public List<ResultData> getResultData(byte[] data) {
        List<ResultData> list = new ArrayList<ResultData>();
        int index = 0;
        String addr = DataUtil.conver2HexStr(data[index]);
        index++;
        String func_code = DataUtil.conver2HexStr(data[index]);
        index++;
        byte data_area_length = data[index];
        index++;
        byte[] data_area = new byte[data_area_length];
        for(int i = 0 ; i < data_area_length/2; i++){
            StringBuffer buffer = new StringBuffer();
            buffer.append(DataUtil.conver2HexStr(data_area[i])+DataUtil.conver2HexStr(data_area[i+1]));
            ResultData result = new ResultData();
            result.setProtocol(getProtocolType());
            result.setAddress(addr);
            result.setCmd_type(func_code);
            result.setData(buffer.toString());
            list.add(result);
            index++;
        }
        return list;
    }

}
