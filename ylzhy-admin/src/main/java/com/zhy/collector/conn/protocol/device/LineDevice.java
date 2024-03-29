package com.zhy.collector.conn.protocol.device;

import com.zhy.collector.conn.protocol.ResultData;
import com.zhy.collector.conn.protocol.device.listener.DeviceListener;
import com.zhy.common.utils.CommonUtil;
import com.zhy.modules.dict.entity.LineEntity;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: ylxny-zhy
 * @Package com.zhy.collector.conn.protocol.device
 * @Description: 回路设备类
 * @date Date : 2018年09月06日 17:35
 */
@Component
public class LineDevice implements DeviceListener {
    //对应的DeviceClient
    private DeviceClient parent;
    //socket channel
    private SocketChannel channel;
    //对应数据库实体类
    private LineEntity lineEntity;
    //回路的命令类
    private Map<Integer, LineCmd> lineCmdMap = new HashMap<Integer, LineCmd>();
    //参数
    private Map<String, List<Double>> params = new HashMap<String, List<Double>>();
    //执行采集的上下文回路
    private LineContext ctx;
    //等待的采集 value : 采集频率
    private List<Integer> waitQueue = new ArrayList<Integer>();

    /**
     * 开始采集事件监听
     * @param frequency
     */
    @Override
    public void startCollect(int frequency) {
        if(!CommonUtil.isNull(ctx)){
            waitQueue.add(frequency);
        }
        ctx = initContext(channel,frequency);
        ctx.setParent(this);
        doCollect(ctx);
    }

    /**
     * 初始化回路上下文
     *
     * @param channel
     * @param frequency
     * @return
     */
    private LineContext initContext(SocketChannel channel, int frequency) {
        ctx = new LineContext();
        ctx.setChannel(channel);
        ctx.setProtocol(lineEntity.getprotocol());
        LineCmd lineCmd = lineCmdMap.get(frequency);
        ctx.setLineCmd(lineCmd);
        return ctx;
    }

    /**
     * 做采集工作
     * @param ctx
     */
    private void doCollect(LineContext ctx) {
        ctx.startWork();
    }

    /**
     * 接收到数据返回
     * @param results
     */
    @Override
    public void msgReceive(List<ResultData> results) {
        ctx.msgReviceNotify(results);
    }

    /**
     * 接口方法 用不到
     * @param data
     */
    @Override
    public void msgReceive(byte[] data) {
    }

    /**
     * 采集完成通知
     * @param lineContext
     */
    public void finishNotify(LineContext lineContext) {
        LineContext context = ctx;
        ctx = null;
        if(!waitQueue.isEmpty()){
            int frequency = waitQueue.get(0);
            waitQueue.remove(0);
            startCollect(frequency);
        }
        context.restWork();
    }

    /*public byte[] getNextCmd(){
        if(exec_cmd_index < (execCmdData.size()-1)){
            byte[] data = getExecCmdData().get(exec_cmd_index);
            status = false;
            exec_cmd_index++;
            return data;
        }else{
            reset();
            if(!waitQueue.isEmpty()){
                frequency = waitQueue.get(0);
                LineCmd lineCmd = lineCmdMap.get(frequency);
                execCmdData.addAll(lineCmd.getCmdDatas());
                deviceClient.sendNextMsg(this);
            }
        }
        return null;
    }*/

    /**
     * 重置
     */
    /*private void reset(){
        writeRecord();
        exec_cmd_index = 0;
        status = true;
        frequency = 0;
        params.clear();
        execCmdData.clear();
        waitQueue.remove(0);
        dataRecord = new DcDataRecordEntity();
    }*/

    /*private void writeRecord() {
        dataRecordService.insert(dataRecord);
    }*/


    /*private void doCalculate() {
        LineCmd lineCmd = lineCmdMap.get(frequency);
        Map<String, DcdCmdDictEntity> calCmdMap = lineCmd.getCalCmdDict();
        for(Iterator<DcdCmdDictEntity> it = calCmdMap.values().iterator(); it.hasNext(); ){
            DcdCmdDictEntity entity = it.next();
            String cmdCode = entity.getCmdCode();
            List<Double> list = params.get(cmdCode);
            if(!CommonUtil.isEmpty(list)){
                Binding bind = new Binding();
                for(int i = 0 ; i < list.size(); i++){
                    Double param = list.get(i);
                    bind.setVariable("param"+(i+1), param);
                }
                GroovyShell shell = new GroovyShell();
                Object o = shell.evaluate(entity.getDataWriteFormula()+"; return RESULT");
                Class clazz = DcDataRecordEntity.class;
                try {
                    Field field = clazz.getDeclaredField(entity.getCmdFlag());
                    field.set(dataRecord, dataRecord);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    /*private void doSet(String key, ResultData result) {
        DcdCmdDictEntity cmdDict = ProtocolManager.newInstance().getCmdDictByKey(key);
        int write_oper = cmdDict.getDataWriteOper();
        try {
            DecimalFormat format = new DecimalFormat();
            if(ProtocolManager.isCalcWrite(write_oper)){
                format.parse(cmdDict.getFormat());
                if(!CommonUtil.isNull(cmdDict.getFormat())){
                    String dataResult = format.format(Double.parseDouble(result.getData()));
                    double data = Double.parseDouble(dataResult) * cmdDict.getFactor();
                    List<Double> list = params.get(cmdDict.getCmdCode());
                    if (!CommonUtil.isNull(list)){
                        //TODO ..此处改成指向某一个采集量的cmdCode 而不是自身的cmdCode
                        params.put(cmdDict.getCmdCode(), list);
                    }
                    int paramIndex = cmdDict.getDataWriteParamIndex();
                    list.add(paramIndex, data);
                }
            } else if(ProtocolManager.isDirectWrite(write_oper)){
                Class clazz = DcDataRecordEntity.class;
                Field field = clazz.getDeclaredField(cmdDict.getCmdFlag());
                if(!CommonUtil.isNull(field)){
                    if(!CommonUtil.isNull(cmdDict.getFormat())){
                        format.parse(cmdDict.getFormat());
                        String dataResult = format.format(Double.parseDouble(result.getData()));
                        double data = Double.parseDouble(dataResult) * cmdDict.getFactor();
                        field.set(dataRecord, data);
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/

    public LineEntity getLineEntity() {
        return lineEntity;
    }

    public void setLineEntity(LineEntity lineEntity) {
        this.lineEntity = lineEntity;
    }

    public LineCmd getLineCmdByFrequency(int frequency){
        return lineCmdMap.get(frequency);
    }

    public Map<Integer, LineCmd> getLineCmdMap() {
        return lineCmdMap;
    }

    public void setLineCmdMap(Map<Integer, LineCmd> lineCmdMap) {
        this.lineCmdMap = lineCmdMap;
    }

    public Map<String, List<Double>> getParams() {
        return params;
    }

    public void setParams(Map<String, List<Double>> params) {
        this.params = params;
    }

    public List<Integer> getWaitQueue() {
        return waitQueue;
    }

    public void setWaitQueue(List<Integer> waitQueue) {
        this.waitQueue = waitQueue;
    }

    public DeviceClient getParent() {
        return parent;
    }

    public void setParent(DeviceClient parent) {
        this.parent = parent;
    }

    public SocketChannel getChannel() {
        return channel;
    }

    public void setChannel(SocketChannel channel) {
        this.channel = channel;
    }
}
