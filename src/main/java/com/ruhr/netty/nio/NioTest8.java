package com.ruhr.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest8 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("input2.txt");
        FileOutputStream outputStream = new FileOutputStream("output2.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);
        while (true) {
            int read = inputStreamChannel.read(byteBuffer);
            System.out.println("read:" + read);
            if (-1 == read) {
                break;
            }
            byteBuffer.flip();
            outputStreamChannel.write(byteBuffer);
            byteBuffer.flip();
        }
        inputStreamChannel.close();
        outputStreamChannel.close();
    }
}
