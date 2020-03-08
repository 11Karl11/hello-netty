package com.ruhr.netty_learn.com.xie.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);
        String fileName = "C:\\Users\\85983\\Desktop\\learnMaven - 副本.rar";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
//        long startTime=System.currentTimeMillis();
//        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
//        System.out.println("发送字节数:"+transferCount+"耗时:"+(System.currentTimeMillis()-startTime));
//        fileChannel.close();

        long startTime = System.currentTimeMillis();
        long total = 0;
        long transferCnt = 0;
        while (total < fileChannel.size()) {
            transferCnt = fileChannel.transferTo(total, fileChannel.size(), socketChannel);//transferTo()会调用操作系统的零拷贝
            total += transferCnt;
        }

        System.out.println("send " + total / 1000.0 + " KB," + "cost " + (System.currentTimeMillis() - startTime) + " ms");

        fileChannel.close();


    }
}
