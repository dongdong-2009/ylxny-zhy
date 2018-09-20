package com.zhy.collector.conn.protocol.modbus;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.conn.protocol.modbus
 * @Description: modbus命令
 * @date Date : 2018年08月28日 10:49
 */
public enum ModbusCMDCode {
    CRC_CMD_READ_BIT(0x02, 1,"读位信息", ""),//读位信息
    CRC_CMD_READ_CRC(0x03, 2,"读单个寄存器", ""),//读单个寄存器
    CRC_CMD_REMOTE_CMD(0x05, 3, "遥控命令", ""),//遥控命令
    CRC_CMD_WRITE_CRC(0x06, 4, "写单个寄存器", ""),//写单个寄存器
    FUNCTION_CODE_UAB((byte)0x03,0x0033, "UAB", "KV"),//UAB
    FUNCTION_CODE_UBC((byte)0x03,0x0034, "UBC", "KV"),//UBC
    FUNCTION_CODE_UCA((byte)0x03,0x0035, "UCA", "KV"),//UCA
    FUNCTION_CODE_U0((byte)0x03,0x0053, "U0", "V"),//U0
    FUNCTION_CODE_IA((byte)0x03,0x0054, "IA", "A"),//IA
    FUNCTION_CODE_IC((byte)0x03,0x0055, "IC", "A"),//IC
    FUNCTION_CODE_I0((byte)0x03,0x0056, "IO", "A"),//IO
    FUNCTION_CODE_I05((byte)0x03,0x0057, "I05", "A"),//I05
    FUNCTION_CODE_UA((byte)0x03,0x0058, "UA", "V"),//UA
    FUNCTION_CODE_UB((byte)0x03,0x0059, "UB", "V"),//UB
    FUNCTION_CODE_UC((byte)0x03,0x005A, "UC", "V"),//UC
    FUNCTION_CODE_POWER((byte)0x03,0x005B, "有功功率", "KW"),//有功功率
    FUNCTION_CODE_POWERLESS((byte)0x03,0x005C, "无功功率", "KW"),//无功功率
    FUNCTION_CODE_POWER_FACTOR((byte)0x03,0x005D, "功率因数", ""),//功率因数
    FUNCTION_CODE_HIGH_POWER_DEGREE((byte)0x03,0x005E,  "电度高16位", ""),//电度高16位
    FUNCTION_CODE_LOW_POWER_DEGREE((byte)0x03,0x005F,  "电度低16位", ""),//电度低16位
    FUNCTION_CODE_IB((byte)0x03,0x0060, "IB", "")//IB
    ;
    private int code;
    private int flag;
    private String name;
    private String measure_unit;

    private ModbusCMDCode(int code , int flag, String name, String measure_unit){
        this.code = code;
        this.flag = flag;
        this.name = name;
        this.measure_unit = measure_unit;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure_unit() {
        return measure_unit;
    }

    public void setMeasure_unit(String measure_unit) {
        this.measure_unit = measure_unit;
    }
}
