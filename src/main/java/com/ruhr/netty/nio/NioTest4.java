package com.ruhr.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream=new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true){
            //byteBuffer.flip();
           // byteBuffer.clear();
            int read = inputStreamChannel.read(byteBuffer);
            System.out.println("read:"+read);
            if (-1==read){
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
