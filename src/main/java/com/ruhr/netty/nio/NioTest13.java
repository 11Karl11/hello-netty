package com.ruhr.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

public class NioTest13 {
    public static void main(String[] args) throws Exception {
        String inputFile = "Niotext13_In.txt";
        String outputFile = "Niotext13_Out.txt";
        RandomAccessFile inputAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputAcessFile = new RandomAccessFile(outputFile, "rw");
        long inputLength = new File(inputFile).length();

        FileChannel inputAccessFileChannel = inputAccessFile.getChannel();
        FileChannel outputAcessFileChannel = outputAcessFile.getChannel();
        MappedByteBuffer inputData = inputAccessFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);


        System.out.println("===========================");

        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        stringCharsetSortedMap.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
        Charset charset = Charset.forName("gbk");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(inputData);
        //System.out.println(charBuffer.get(0));
        //ByteBuffer outputData = encoder.encode(charBuffer);
        ByteBuffer outputData = Charset.forName("utf-8").encode(charBuffer);
        outputAcessFileChannel.write(outputData);
        inputAccessFile.close();
        outputAcessFile.close();


    }
}
