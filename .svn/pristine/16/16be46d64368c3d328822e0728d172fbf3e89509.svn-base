package com.zhy.collector.conn.protocol;


import com.zhy.common.utils.CommonUtil;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.data.protocol
 * @Description: 数据类基础类
 * @date Date : 2018年08月23日 14:49
 */
public abstract class BaseData {
    //帧数据对应的字节数组
    protected byte[] frameBytes;
    //数据对应字节数
    protected Integer capacity;

    public byte[] getFrameBytes() {
        return frameBytes;
    }

    public void setFrameBytes(byte[] frameBytes) {
        this.frameBytes = frameBytes;
    }

    public Integer getCapacity() {
        if(CommonUtil.isNull(capacity)){
            capacity = caculateCapacity();
        }
        return capacity;
    }

    protected abstract Integer caculateCapacity();

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


}
