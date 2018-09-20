package com.zhy.collector.conn.protocol.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

import java.util.Arrays;
import java.util.List;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.data.protocol.dlt
 * @Description: 基础协议编码  方便扩展用
 * @date Date : 2018年08月24日 12:09
 */
public class BaseProtocolEncoder extends ByteArrayEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, byte[] msg, List<Object> out) throws Exception {
        if (msg.length != 0) {
            out.add(Arrays.asList(msg));
        }
        super.encode(ctx, msg, out);
    }
}
