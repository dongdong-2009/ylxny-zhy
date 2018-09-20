package com.zhy.collector.conn.protocol.device;


import com.zhy.collector.conn.protocol.BaseData;
import com.zhy.collector.conn.protocol.Protocol;
import com.zhy.collector.conn.protocol.ResultData;

import java.util.List;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.conn.protocol.device.dtu
 * @Description: 解析dtu对应的数据
 * @date Date : 2018年08月30日 17:08
 */
public class DTUProtocol extends Protocol<BaseData> {
    public static int REGISTER_LENGTH = 26;
    public static int HEART_BEAT_LENGTH = 1;

    public static final String PROTOCOL_DTU_TITLE = "XMYN";

    public static final int PROTOCOL_DTU_TITLE_START_INDEX = 4;
    public static final int PROTOCOL_DTU_TITLE_END_INDEX = 13;

    @Override
    public void encode(BaseData baseData) {
    }

    @Override
    public void decode(BaseData baseData) {
    }

    @Override
    public void dispatch(BaseData baseData) {
    }

    @Override
    protected boolean patternMatch(byte[] data) {
        if(data.length == HEART_BEAT_LENGTH & '$' == data[0]){
            return true;
        }else if(data.length == REGISTER_LENGTH){
            StringBuffer s = new StringBuffer();
            for(int i = 0 ; i < data.length; i++){
                s.append((char)data[i]);
            }
            System.out.println(s.toString());
            if(s.toString().startsWith(DTUProtocol.PROTOCOL_DTU_TITLE)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    protected boolean validate(byte[] frameBytes) {
        return true;
    }

    @Override
    public int getProtocolType() {
        return 0;
    }

    @Override
    public List<ResultData> getResultData(byte[] data) {
        return null;
    }

}
