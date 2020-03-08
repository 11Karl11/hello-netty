package com.ruhr.netty_learn.com.xie.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @Description TODO
 * @Date 2020/2/27 22:29
 * @Created by xiezw
 */
public class ByteBufTest0 {
    public static void main(String[] args) {
        ByteBuf buffer= Unpooled.buffer(10);
        for (int i=0;i<10;i++){
            buffer.writeByte(i);
        }

        for (int i=0;i<buffer.capacity();++i){
            System.out.println(buffer.getByte(i));
        }

    }
}
