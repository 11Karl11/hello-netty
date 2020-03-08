package com.ruhr.netty_learn.com.xie.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @Description TODO
 * @Date 2020/2/27 23:10
 * @Created by xiezw
 */
public class ByteBufTest1 {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.copiedBuffer("张hello world", Charset.forName("utf-8"));
        if (buffer.hasArray()){
            byte[] content = buffer.array();
            System.out.println(new String(content,Charset.forName("utf-8")));
            System.out.println(buffer);

            System.out.println(buffer.arrayOffset());
            System.out.println(buffer.readerIndex());
            System.out.println(buffer.writerIndex());
            System.out.println(buffer.capacity());


            System.out.println(buffer.readableBytes());

            for (int i=0;i<buffer.readableBytes();++i){
                System.out.println((char) buffer.getByte(i));
            }

            System.out.println(buffer.getCharSequence(0,4,Charset.forName("utf-8")));
            System.out.println(buffer.getCharSequence(4,6,Charset.forName("utf-8")));
        }

    }
}
