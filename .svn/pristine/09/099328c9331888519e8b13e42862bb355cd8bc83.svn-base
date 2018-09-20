package com.zhy.collector.conn.protocol.device;

import com.zhy.modules.dict.entity.CmdDictEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package com.zhy.collector.conn.protocol.device
 * @Description: 回路命令 根据采集频率划分
 * @User: zengqiang
 * @Date: 2018-09-08
 */
public class LineCmd {
    //采集频率
    private int frequency;
    //需要计算的命令字典
    private Map<String, CmdDictEntity> calCmdDict = new HashMap<String, CmdDictEntity>();
    //读取数据的命令
    private List<byte[]> cmdDatas = new ArrayList<byte[]>();

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Map<String, CmdDictEntity> getCalCmdDict() {
        return calCmdDict;
    }

    public void setCalCmdDict(Map<String, CmdDictEntity> calCmdDict) {
        this.calCmdDict = calCmdDict;
    }

    public List<byte[]> getCmdDatas() {
        return cmdDatas;
    }

    public void setCmdDatas(List<byte[]> cmdDatas) {
        this.cmdDatas = cmdDatas;
    }

    public void addCalcCmdDict(CmdDictEntity entity){
        calCmdDict.put(entity.getcmd_code(), entity);
    }

    public void addDataList(byte[] data) {
        cmdDatas.add(data);
    }

}