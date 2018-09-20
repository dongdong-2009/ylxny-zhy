package com.zhy.collector.conn.protocol.device.task;


import com.zhy.collector.conn.protocol.device.DeviceClient;
import com.zhy.collector.conn.protocol.device.DeviceManager;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.conn.protocol.device.dtu.task
 * @Description: dtu定时任务
 * @date Date : 2018年09月04日 17:40
 */
public class DtuOnlineTask implements Runnable{

    //设置掉线时间间隔标准为两分钟
    private static final int MINITE_INTERVAL = 2;

    @Override
    public void run() {
        long currentMinite = (new Date()).getTime() / (1000 * 60);
        Map<String, DeviceClient> clients = DeviceManager.newInstance().getClients();
        for(Iterator<DeviceClient> it = clients.values().iterator(); it.hasNext(); ){
            DeviceClient client = it.next();
            long statusTime = client.getStatusTime();
            if(currentMinite - statusTime > MINITE_INTERVAL){
                String id = client.getDtuDevice().getdevice_id();
                DeviceManager.newInstance().removeIdAndIpMap(id);
                DeviceManager.newInstance().removeClient(client.getIp());
            }
        }
    }
}
