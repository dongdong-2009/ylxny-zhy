package com.zhy.collector.conn.protocol.modbus.codec;

import com.zhy.collector.conn.protocol.codec.BaseProtocolEncoder;
import io.netty.channel.ChannelHandlerContext;

import java.util.Arrays;
import java.util.List;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.conn.protocol.modbus.codec
 * @Description: modbus协议封装
 * @date Date : 2018年08月28日 10:36
 */
public class ModbusProtocolEncoder extends BaseProtocolEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, byte[] msg, List<Object> out) throws Exception {
        if (msg.length != 0) {
            out.add(Arrays.asList(msg));
        }
        super.encode(ctx, msg, out);
    }
}
