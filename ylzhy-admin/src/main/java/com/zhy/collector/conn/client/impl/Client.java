package com.zhy.collector.conn.client.impl;

import com.zhy.collector.conn.client.IClient;
import com.zhy.collector.conn.client.handler.ClientHandler;
import com.zhy.collector.conn.protocol.dlt.codec.DLTProtocolDecoder;
import com.zhy.collector.conn.protocol.dlt.codec.DLTProtocolEncoder;
import com.zhy.common.utils.CommonUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.datacollector.connection.client
 * @Description: 客户端 做测试用
 * @date Date : 2018年08月21日 15:57
 */
public class Client implements IClient {

    private Logger logger = LoggerFactory.getLogger(Client.class);
    //客服端启动类
    private Bootstrap bootstrap;
    //EventLoopGroup
    private EventLoopGroup group;
    //channelFutrue
    private ChannelFuture future;



    /**
     * 客户端初始化
     */
    @Override
    public void init() {
        logger.info("...........................数据采集器客户端初始化   开始...........................");
        bootstrap = new Bootstrap();
        group = new NioEventLoopGroup();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline pipeline = socketChannel.pipeline();
                pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
//                pipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
//                pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                pipeline.addLast("protocolDecoder",new DLTProtocolDecoder());
                pipeline.addLast("protocolEncoder", new DLTProtocolEncoder());
                pipeline.addLast(new ClientHandler());
            }
        });
        logger.info("...........................数据采集器客户端初始化   完成...........................");
    }

    /**
     * 客户端启动
     */
    @Override
    public void start() {
        logger.info("...........................数据采集器客户端启动   开始...........................");
        //1.初始胡
        init();
        //2.启动
        try {
            future = bootstrap.connect(ClientConfig.ip, ClientConfig.port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.info("...........................数据采集器客户端启动   失败...........................");
        } finally {
            //close();
        }
        logger.info("...........................数据采集器客户端启动   完成...........................");
    }

    /**
     * 客户端关闭
     */
    @Override
    public void close() {
        logger.info("...........................数据采集器客户端关闭   开始...........................");
        if (!CommonUtil.isNull(group)){
            group.shutdownGracefully();
        }
        if(!CommonUtil.isNull(bootstrap)){
            bootstrap.clone();
        }
        logger.info("...........................数据采集器客户端关闭   完成...........................");
    }

    public void sendMsg(String msg){
        logger.info("客户端发送数据："+msg);
        //future.channel().writeAndFlush(msg);
        sendData();
    }

    public void sendData(){
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put((byte) 0x91);
        byte[] data = new byte[]{0x68,0x61,0x01,0x00,0x00,0x00,0x00,0x68,(byte) 0x91,0x06,0x33,0x34,0x34,0x35,0x34,0x43,0x10,0x16};
        future.channel().writeAndFlush(data);
    }


}
