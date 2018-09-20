package com.zhy.collector.conn.protocol.device.listener;


import com.zhy.collector.conn.protocol.ResultData;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package com.zhy.collector.conn.protocol.device
 * @Description: 设备监听器接口
 * @User: zengqiang
 * @Date: 2018-09-11
 */
public interface DeviceListener {

    //开始采集
    public void startCollect(int frequency);

    //收到信息
    public void msgReceive(byte[] data);

    //收到信息
    public void msgReceive(List<ResultData> results);
}