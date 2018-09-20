package com.zhy.collector.conn.protocol.device;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zhy.collector.data.db.DBManagerUtil;
import com.zhy.common.utils.CommonUtil;
import com.zhy.modules.dict.entity.DeviceEntity;
import com.zhy.modules.dict.entity.LineEntity;
import com.zhy.modules.dict.service.DeviceService;
import com.zhy.modules.dict.service.LineService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.conn.server
 * @Description: 客户端管理
 * @date Date : 2018年08月31日 11:47
 */
@Component
public class DeviceManager {
    private static DeviceManager DeviceManager = new DeviceManager();
    //设备客户端 key为ip
    private static Map<String, DeviceClient> clients = new HashMap<String, DeviceClient>();
    //设备列表 key为设备id
    private static Map<String, DeviceEntity> devices = new HashMap<String, DeviceEntity>();
    //回路列表
    private static Map<String, Map<String, LineEntity>> lineMap = new HashMap<String, Map<String,LineEntity>>();
    //设备id 与 ip映射表
    private static Map<String, String> idAndIpMap = new HashMap<String, String>();

    //dtu协议
    private static DTUProtocol dtuProtocol = new DTUProtocol();

    DeviceService dcdDeviceService;
    LineService dcdLineService;

    private DeviceManager(){
    }

    public static DeviceManager newInstance(){
        if(DeviceManager == null){
            DeviceManager = new DeviceManager();
        }
        return DeviceManager;
    }

    @PostConstruct
    public void initService(){
        setDcdDeviceService(DBManagerUtil.newInstance().getDeviceService());
        setDcdLineService(DBManagerUtil.newInstance().getLineService());
    }

    public void init() {
        initService();
        //初始化DTU列表
        Wrapper wrapper = new Wrapper<DeviceEntity>() {
            @Override
            public String getSqlSegment() {
                return null;
            }
        };
        List<DeviceEntity> list = dcdDeviceService.selectList(wrapper);
        for(Iterator<DeviceEntity> it = list.iterator(); it.hasNext(); ){
            DeviceEntity device = it.next();
            Wrapper<LineEntity> w = new Wrapper<LineEntity>() {
                @Override
                public String getSqlSegment() {
                    return null;
                }
            };
            w.eq("device_id",device.getdevice_id());
            List<LineEntity> l = dcdLineService.selectList(w);
            Map<String, LineEntity> map = new HashMap<String, LineEntity>();
            for(Iterator<LineEntity> iterator = l.iterator(); iterator.hasNext();){
                LineEntity line = iterator.next();
                map.put(line.getaddress(), line);
            }
            lineMap.put(device.getdevice_id(), map);
        }
    }

    /**
     * 过滤dtu数据
     * @param data
     */
    public static boolean filterDTUMsg(byte[] data) {
        if(dtuProtocol.matchProtocol(data)){
            return true;
        }
        return false;
    }

    /***
     * 移除dtu客户端 并移除id与ip映射
     * @param ip
     */
    public void removeClient(String ip) {
        DeviceClient client = getClientByIp(ip);
        if(!CommonUtil.isNull(client)){
            String id = client.getDtuDevice().getdevice_id();
            removeIdAndIpMap(id);
        }
    }

    public void addListener(String key , DeviceClient value){
        clients.put(key,value);
    }

    public void removeClientByIp(String key){
        clients.remove(key);
    }

    public DeviceClient getClientByIp(String key){
        return clients.get(key);
    }

    public void addDeviceById(String key, DeviceEntity value){
        devices.put(key,value);
    }

    public void removeDeviceById(String key){
        devices.remove(key);
    }

    public DeviceEntity getDeviceById(String key){
        return devices.get(key);
    }

    public void addIdAndIpMap(String id, String ip) {
        idAndIpMap.put(id, ip);
    }

    public String getIdAndIpMap(String id) {
        return idAndIpMap.get(id);
    }

    public Map<String, DeviceClient> getClients() {
        return clients;
    }

    public void setClients(Map<String, DeviceClient> clients) {
        this.clients = clients;
    }

    public Map<String, String> getIdAndIpMap() {
        return idAndIpMap;
    }

    public void setIdAndIpMap(Map<String, String> idAndIpMap) {
        this.idAndIpMap = idAndIpMap;
    }

    public void removeIdAndIpMap(String id){
        idAndIpMap.remove(id);
    }

    public Map<String, LineEntity> getLineMap(String device_id){
        return lineMap.get(device_id);
    }

    public static Map<String, Map<String, LineEntity>> getLineMap() {
        return lineMap;
    }

    public DeviceService getDcdDeviceService() {
        return dcdDeviceService;
    }

    public void setDcdDeviceService(DeviceService dcdDeviceService) {
        this.dcdDeviceService = dcdDeviceService;
    }

    public LineService getDcdLineService() {
        return dcdLineService;
    }

    public void setDcdLineService(LineService dcdLineService) {
        this.dcdLineService = dcdLineService;
    }
}
