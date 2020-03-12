package com.ruhr.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @Description TODO
 * @Date 2020/3/8 14:47
 * @Created by xiezw
 */
public class MyLongToString extends MessageToMessageDecoder<Long> {
    @Override
    protected void decode(ChannelHandlerContext ctx, Long msg, List<Object> out) throws Exception {
        System.out.println("MessageToMessageDecoder decode invoked");
        out.add(String.valueOf(msg));
    }
}
