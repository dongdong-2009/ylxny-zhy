package com.zhy.collector.conn.protocol.dlt;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.data.protocol.dlt
 * @Description: TODO
 * @date Date : 2018年08月24日 10:56
 */
public enum DLTCMDCode {

    FUNCTION_CODE_REQ_POSITIVE_POWER(0x11,0x00000100,"",""),//正向有功总电能请求
    FUNCTION_CODE_REQ_REVERSE_POWER(0x11,0x00000200,"",""),//反向有功总电能请求
    FUNCTION_CODE_REQ_POSITIVE_POWERLESS(0x11,0x00000300,"",""),//正向无功总电能请求
    FUNCTION_CODE_REQ_REVERSE_POWERLESS(0x11,0x00000400,"",""),//反向无功总电能请求
    FUNCTION_CODE_REQ_A_VOLTAGE(0x11,0x00010102,"",""),//A相电压请求
    FUNCTION_CODE_REQ_A_CURRRENT(0x11,0x00010202,"",""),//A相电流请求
    FUNCTION_CODE_REQ_INSTANTE_POWER(0x11,0x00000302,"",""),//瞬时有功请求
    FUNCTION_CODE_REQ_INSTANCE_POWERLESS(0x11,0x00000402,"",""),//瞬时无功请求
    FUNCTION_CODE_REQ_INSTANCE_TOTAL_POWER(0x11,0x00000502,"",""),//瞬时视在总功请求
    FUNCTION_CODE_RESP_POSITIVE_POWER((byte)0x91,0x00000100,"",""),//正向有功总电能响应
    FUNCTION_CODE_RESP_REVERSE_POWER((byte)0x91,0x00000200,"",""),//反向有功总电能响应
    FUNCTION_CODE_RESP_POSITIVE_POWERLESS((byte)0x91,0x00000300,"",""),//正向无功总电能响应
    FUNCTION_CODE_RESP_REVERSE_POWERLESS((byte)0x91,0x00000400,"",""),//反向无功总电能响应
    FUNCTION_CODE_RESP_A_VOLTAGE((byte)0x91,0x00010102,"###.#","V"),//A相电压响应
    FUNCTION_CODE_RESP_A_CURRRENT((byte)0x91,0x00010202,"###.###","A"),//A相电流响应
    FUNCTION_CODE_RESP_INSTANTE_POWER((byte)0x91,0x00000302,"",""),//瞬时有功响应
    FUNCTION_CODE_RESP_INSTANCE_POWERLESS((byte)0x91,0x00000402,"",""),//瞬时无功响应
    FUNCTION_CODE_RESP_INSTANCE_TOTAL_POWER((byte)0x91,0x00000502,"",""),//瞬时视在总功响应
    ;
    private DLTCMDCode(int code, int flag, String format, String measure_unit){
        this.code = code;
        this.flag = flag;
        this.format = format;
        this.measure_unit = measure_unit;
    }

    private int code;
    private int flag;
    private String format;
    private String measure_unit;//单位

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMeasure_unit() {
        return measure_unit;
    }

    public void setMeasure_unit(String measure_unit) {
        this.measure_unit = measure_unit;
    }

    //匹配命令
    public boolean match(int code , long flag){
        if(code == getCode() && flag == getFlag()){
            return true;
        }
        return false;
    }

}
