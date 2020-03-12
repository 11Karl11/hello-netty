package com.ruhr.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Description TODO
 * @Date 2020/3/3 21:54
 * @Created by xiezw
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encoder invoked");
        System.out.println(msg);
        out.writeLong(msg);
    }
}
