package com.ruhr.netty.handler3;

/**
 * @Description TODO
 * @Date 2020/3/8 17:24
 * @Created by xiezw
 */
public class PersonProtocol {
    private int length;
    private byte[] content;


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
