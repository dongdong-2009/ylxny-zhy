package com.zhy.collector.conn.protocol;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: ylxny-zhy
 * @Package com.zhy.collector.conn.protocol
 * @Description: 查询的返回数据
 * @date Date : 2018年09月07日 13:35
 */
public class ResultData {
    private int protocol;
    private String address;
    private String cmd_type;
    private String cmd;
    private String data;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public String getCmd_type() {
        return cmd_type;
    }

    public void setCmd_type(String cmd_type) {
        this.cmd_type = cmd_type;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
