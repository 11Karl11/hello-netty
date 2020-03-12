package com.ruhr.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Description TODO
 * @Date 2020/3/3 21:41
 * @Created by xiezw
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("decoder invoked");
        System.out.println(in.readableBytes());
        if (in.readableBytes()>=8){
            out.add(in.readLong());
        }
    }
}
