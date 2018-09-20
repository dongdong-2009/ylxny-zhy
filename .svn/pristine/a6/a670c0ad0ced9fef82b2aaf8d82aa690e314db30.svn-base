package com.zhy.collector.conn.protocol.modbus;


import com.zhy.collector.conn.protocol.BaseData;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.conn.protocol.modbus
 * @Description: modbus数据帧
 * @date Date : 2018年08月28日 10:27
 */
public class ModbusFrameData extends BaseData {
    //地址码
    private byte addr_code;
    //功能码
    private byte func_code;
    //对应的命令标识
    private byte[] flag;
    //起始地址
    private byte[] start_addr;
    //数据总数
    private byte[] data_num;
    //数据区长度
    private byte data_area_length;
    //数据区
    private byte[] data_area;
    //校验位
    private byte[] crc_code;


    public byte getAddr_code() {
        return addr_code;
    }

    public void setAddr_code(byte addr_code) {
        this.addr_code = addr_code;
    }

    public byte getFunc_code() {
        return func_code;
    }

    public void setFunc_code(byte func_code) {
        this.func_code = func_code;
    }

    public byte[] getData_area() {
        return data_area;
    }

    public void setData_area(byte[] data_area) {
        this.data_area = data_area;
    }

    public byte[] getFlag() {
        return flag;
    }

    public void setFlag(byte[] flag) {
        this.flag = flag;
    }

    public byte getData_area_length() {
        return data_area_length;
    }

    public void setData_area_length(byte data_area_length) {
        this.data_area_length = data_area_length;
    }

    public byte[] getCrc_code() {
        return crc_code;
    }

    public void setCrc_code(byte[] crc_code) {
        this.crc_code = crc_code;
    }

    public byte[] getStart_addr() {
        return start_addr;
    }

    public void setStart_addr(byte[] start_addr) {
        this.start_addr = start_addr;
    }

    public byte[] getData_num() {
        return data_num;
    }

    public void setData_num(byte[] data_num) {
        this.data_num = data_num;
    }

    //固定长度8字节
    @Override
    protected Integer caculateCapacity() {
        return 8;
    }
}
