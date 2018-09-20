package com.zhy.collector.conn.protocol.dlt;


import com.zhy.collector.conn.protocol.BaseData;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.data.protocol.frame
 * @Description: DLT帧的数据项构成
 * @date Date : 2018年08月23日 14:40
 */
public class DLTFrameData extends BaseData {
    //帧的最短长度
    public static int FRAME_BASIC_LENGTH = 12;
    //帧的地址域长度
    public static int FRAME_ADDRESS_LENGTH = 6;

    //起始标识 1字节
    private byte flag_start_1;
    private byte flag_start_2;
    //结束标识 1字节
    private byte flag_end_1;
    //地址域A 6字节
    private byte[] substation_addr = new byte[6];
    //控制码 C 1字节
    private byte control_code;
    //数据域长度 L
    private byte data_area_length;
    //数据域 DATA
    private byte[] data_area;
    //校验码 CS
    private byte cs_code;
    //数据域标识
    private int data_area_flag;
    //数据域数据
    private byte[] main_data;

    public byte getFlag_start_1() {
        return flag_start_1;
    }

    public void setFlag_start_1(byte flag_start_1) {
        this.flag_start_1 = flag_start_1;
    }

    public byte getFlag_start_2() {
        return flag_start_2;
    }

    public void setFlag_start_2(byte flag_start_2) {
        this.flag_start_2 = flag_start_2;
    }

    public byte getFlag_end_1() {
        return flag_end_1;
    }

    public void setFlag_end_1(byte flag_end_1) {
        this.flag_end_1 = flag_end_1;
    }

    public byte[] getSubstation_addr() {
        return substation_addr;
    }

    public void setSubstation_addr(byte[] substation_addr) {
        this.substation_addr = substation_addr;
    }

    public byte getControl_code() {
        return control_code;
    }

    public void setControl_code(byte control_code) {
        this.control_code = control_code;
    }

    public byte getData_area_length() {
        return data_area_length;
    }

    public void setData_area_length(byte data_area_length) {
        this.data_area_length = data_area_length;
    }

    public byte[] getData_area() {
        return data_area;
    }

    public void setData_area(byte[] data_area) {
        this.data_area = data_area;
    }

    public byte getCs_code() {
        return cs_code;
    }

    public void setCs_code(byte cs_code) {
        this.cs_code = cs_code;
    }

    @Override
    protected Integer caculateCapacity() {
        return FRAME_BASIC_LENGTH + data_area_length;
    }

    public int getData_area_flag() {
        return data_area_flag;
    }

    public void setData_area_flag(int data_area_flag) {
        this.data_area_flag = data_area_flag;
    }

    public byte[] getMain_data() {
        return main_data;
    }

    public void setMain_data(byte[] main_data) {
        this.main_data = main_data;
    }
}
