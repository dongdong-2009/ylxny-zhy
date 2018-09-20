package com.zhy.collector.conn.protocol.dlt.codec;

import com.zhy.collector.conn.protocol.Protocol;
import com.zhy.collector.conn.protocol.codec.BaseProtocolDecoder;
import com.zhy.collector.conn.protocol.dlt.DLTFrameData;
import com.zhy.collector.conn.protocol.dlt.DLTProtocol;
import com.zhy.common.utils.CommonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.Iterator;
import java.util.List;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.data.protocol.dlt.dlt
 * @Description: DLT解码器
 * @date Date : 2018年08月24日 10:39
 */
public class DLTProtocolDecoder extends BaseProtocolDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        super.decode(ctx, msg, out);
        if(CommonUtil.isEmpty(out)){
            return;
        }
        for(Iterator it = out.iterator(); it.hasNext();){
            Object obj = it.next();
            if(obj instanceof String){
                return;
            }
            byte[] data = (byte[])obj;
            if(data.length == 1 && '$' == (char) data[0]){
                //心跳包
                System.out.println("接收到心跳字符$，不做解析！");
                return;
            }else if (data.length > 16 && data[0] == (byte)0xFE){
                //可读数据
                DLTFrameData frameData= new DLTFrameData();
                frameData.setFrameBytes(data);
                Protocol protocol = new DLTProtocol();
                protocol.decode(frameData);
                protocol.dispatch(frameData);
                return;
            }else if(data.length == 26){
                StringBuffer s = new StringBuffer();
                for(int i = 0 ; i < data.length; i++){
                    s.append((char)data[i]);
                }
                System.out.println(s.toString());
            }
        }
    }
}
