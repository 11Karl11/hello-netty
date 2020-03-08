package com.ruhr.netty_learn.com.xie.nio;

import io.netty.buffer.ByteBuf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream=new FileInputStream("NioTest2.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuf= ByteBuffer.allocate(512);
        fileChannel.read(byteBuf);
        byteBuf.flip();
        while (byteBuf.remaining()>0){
            byte b = byteBuf.get();
            System.out.println("Character:"+(char)b);
        }
        fileInputStream.close();
    }
}
