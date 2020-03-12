package com.ruhr.netty.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @Description TODO
 * @Date 2020/3/8 17:32
 * @Created by xiezw
 */
public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        byte[] content = msg.getContent();
        int length = msg.getLength();
        System.out.println("服务器收到数据:");
        System.out.println("长度:"+length);
        System.out.println("内容:"+new String(content, Charset.forName("utf-8")));
        System.out.println("服务器收到的消息数量"+(++this.count));
        String responseMsg= UUID.randomUUID().toString();
        int responseLength=responseMsg.getBytes("utf-8").length;
        byte[] responseMsgBytes = responseMsg.getBytes("utf-8");
        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setContent(responseMsgBytes);
        personProtocol.setLength(responseLength);
        ctx.writeAndFlush(personProtocol);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
