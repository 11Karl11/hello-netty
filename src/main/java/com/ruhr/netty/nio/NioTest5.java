package com.ruhr.netty.nio;

import java.nio.ByteBuffer;

public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.putInt(15);
        byteBuffer.putLong(11111111111111L);
        byteBuffer.putDouble(12.22);
        byteBuffer.putChar('你');
        byteBuffer.putShort((short)2);
        byteBuffer.putChar('我');
        byteBuffer.flip();
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getChar());


    }
}
