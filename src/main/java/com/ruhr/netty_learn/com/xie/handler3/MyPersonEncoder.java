package com.ruhr.netty_learn.com.xie.handler3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Description TODO
 * @Date 2020/3/8 17:31
 * @Created by xiezw
 */
public class MyPersonEncoder extends MessageToByteEncoder<PersonProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, PersonProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyPersonEncoder encode invoked!");
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }
}
