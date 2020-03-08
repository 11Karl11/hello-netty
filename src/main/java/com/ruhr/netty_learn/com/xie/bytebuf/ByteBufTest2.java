package com.ruhr.netty_learn.com.xie.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Iterator;

/**
 * @Description TODO
 * @Date 2020/2/28 21:43
 * @Created by xiezw
 */
public class ByteBufTest2 {
    public static void main(String[] args) {
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        ByteBuf heapBuffer = Unpooled.buffer(10);
        ByteBuf directBuffer = Unpooled.directBuffer(8);
        compositeByteBuf.addComponents(heapBuffer,directBuffer);
        //compositeByteBuf.removeComponent(0);
        Iterator<ByteBuf> iterator = compositeByteBuf.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        compositeByteBuf.forEach(System.out::println);

    }
}
