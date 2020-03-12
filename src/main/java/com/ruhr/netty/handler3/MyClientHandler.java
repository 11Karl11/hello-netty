package com.ruhr.netty.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @Description TODO
 * @Date 2020/3/8 17:38
 * @Created by xiezw
 */
public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        byte[] content = msg.getContent();
        int length = msg.getLength();
        System.out.println("客户端接收到的消息:");
        System.out.println("长度:"+ length);
        System.out.println("内容"+new String(content, Charset.forName("utf-8")));
        System.out.println("客户端收到的消息数量"+(++this.count));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i=0;i<10;++i){
            String messageToBytes="sent from client";
            byte[] bytes = messageToBytes.getBytes(Charset.forName("utf-8"));
            int length = messageToBytes.getBytes(Charset.forName("utf-8")).length;
            PersonProtocol personProtocol = new PersonProtocol();
            personProtocol.setLength(length);
            personProtocol.setContent(bytes);
            ctx.writeAndFlush(personProtocol);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        ctx.close();
    }
}
