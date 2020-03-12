package com.ruhr.netty.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioTest12 {
    public static void main(String[] args) throws Exception {
        int[] ports=new int[5];
        ports[0]=5000;
        ports[1]=5001;
        ports[2]=5002;
        ports[3]=5003;
        ports[4]=5004;
        Selector selector=Selector.open();
        for (int i=0;i<ports.length;++i){
            ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket=serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress(ports[i]));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口:"+ports[i]);
        }

        while (true){
            int num = selector.select();
            System.out.println("number:"+num);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectedKeys:"+selectionKeys);
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()){
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    iterator.remove();
                    System.out.println("获得客户端连接:"+socketChannel);
                }else if (selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int byteRead=0;
                    while (true){
                        ByteBuffer buffer = ByteBuffer.allocate(512);
                        buffer.clear();
                        int read = socketChannel.read(buffer);
                        if (read<=0){
                            break;
                        }
                        buffer.flip();
                        socketChannel.write(buffer);
                        byteRead+=read;

                    }
                    System.out.println("读取:"+byteRead+",来自于:"+socketChannel);
                    iterator.remove();

                }
            }
        }
    }
}
