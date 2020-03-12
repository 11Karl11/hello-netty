package com.ruhr.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @Description TODO
 * @Date 2020/3/3 22:35
 * @Created by xiezw
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder2 decode invokedd");
        out.add(in.readLong());
    }
}
