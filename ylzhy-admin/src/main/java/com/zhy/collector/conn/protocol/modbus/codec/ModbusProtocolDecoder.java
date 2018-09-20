package com.zhy.collector.conn.protocol.modbus.codec;

import com.zhy.collector.conn.protocol.BaseData;
import com.zhy.collector.conn.protocol.Protocol;
import com.zhy.collector.conn.protocol.codec.BaseProtocolDecoder;
import com.zhy.collector.conn.protocol.modbus.ModbusFrameData;
import com.zhy.collector.conn.protocol.modbus.ModbusProtocol;
import com.zhy.common.utils.CommonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.Iterator;
import java.util.List;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.conn.protocol.modbus.codec
 * @Description: modbus协议解析
 * @date Date : 2018年08月28日 10:36
 */
public class ModbusProtocolDecoder extends BaseProtocolDecoder {
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
            }else if(data.length == 26){
                StringBuffer s = new StringBuffer();
                for(int i = 0 ; i < data.length; i++){
                    s.append((char)data[i]);
                }
                System.out.println(s.toString());
                return;
            }else if (data.length >= 7){
                //可读数据
                BaseData frameData= new ModbusFrameData();
                frameData.setFrameBytes(data);
                Protocol protocol = new ModbusProtocol();
                protocol.decode(frameData);
                protocol.dispatch(frameData);
                return;
            }
        }
    }
}
