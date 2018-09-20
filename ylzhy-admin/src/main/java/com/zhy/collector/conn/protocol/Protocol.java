package com.zhy.collector.conn.protocol;

import com.zhy.collector.conn.protocol.dlt.DLTProtocol;
import com.zhy.collector.conn.protocol.modbus.ModbusProtocol;
import com.zhy.collector.util.DataUtil;

import java.util.List;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.data.protocol
 * @Description: 协议类接口
 * @date Date : 2018年08月23日 14:45
 */
public abstract class Protocol<BaseData> {
    //协议标识
    public static final int PROTOCOL_TYPE_DLT645 = 1;
    public static final int PROTOCOL_TYPE_MODBUS = 2;

    public static Protocol getProtocolByType(int type) {
        if(PROTOCOL_TYPE_DLT645 == type){
            return new DLTProtocol();
        }else if (PROTOCOL_TYPE_MODBUS == type){
            return new ModbusProtocol();
        }
        return null;
    }

    public abstract void encode(BaseData data);

    public abstract void decode(BaseData data);

    public abstract void dispatch(BaseData data);

    public boolean matchProtocol(byte[] frameBytes){
        return patternMatch(frameBytes) & validate(frameBytes);
    }

    protected abstract boolean patternMatch(byte[] frameBytes);

    protected abstract boolean validate(byte[] frameBytes);

    public static byte[] encodeByProtocol(int protocol_type, String cmd_type, String cmd, String cmd_code, String address, int start_position, int cmd_count){
        if(protocol_type == Protocol.PROTOCOL_TYPE_DLT645){
            int index = 0;
            byte[] data = new byte[16];
            data[index] = DLTProtocol.START_FLAG;
            index++;
            int add_len = address.length()/2;
            String[] addrArr = address.split(" ");
            for(int i = 0 ; i < DLTProtocol.ADDRESS_BYTES_COUNT; i++){
                byte b = DataUtil.hexString2Byte(addrArr[add_len-1 -i]);
                data[index] = b;
                //高位补0
                if(i >= add_len){
                    data[index] = 0x00;
                }
                index++;
            }
            data[index] = DLTProtocol.START_FLAG;
            index++;
            data[index] = DataUtil.hexString2Byte(cmd_type);
            index++;
            int cmd_len = cmd.length();
            data[index] = (byte)cmd_len;
            index++;
            String[] cmdArr = cmd.split(" ");
            for(int i = 0 ; i < cmd_len; i++){
                data[index] = DataUtil.hexString2Byte(cmdArr[i]);
                index++;
            }
            byte cs_code = DataUtil.getCs_code(data);
            data[index] = cs_code;
            index++;
            data[index] = DLTProtocol.END_FLAG;
        }else if (protocol_type == Protocol.PROTOCOL_TYPE_MODBUS){
            int index = 0;
            byte[] data = new byte[8];
            data[index] = DataUtil.hexString2Byte(address);
            index++;
            data[index] = DataUtil.hexString2Byte(cmd_type);
            index++;
            String[] codeArr = cmd_code.split(" ");
            for(int i = 0 ; i < codeArr.length; i++){
                data[index] = DataUtil.hexString2Byte(codeArr[i]);
                index++;
            }
            String countStr = Integer.toHexString(cmd_count & 0xFFF);
            byte[] b = DataUtil.hexString2Bytes(countStr);
            for(int i = 0 ; i < b.length; i++){
                data[index] = b[i];
                index++;
            }
            String crc_code = DataUtil.getCrc16(data);
            byte[] crc = DataUtil.hexString2Bytes(crc_code);
            for(int i = 0 ; i < crc.length; i++){
                data[index] = crc[i];
                index++;
            }
        }
        return null;
    }

    public abstract int getProtocolType();

    public abstract List<ResultData> getResultData(byte[] data);

}
