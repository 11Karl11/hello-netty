package com.ruhr.netty.six;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author karl xie
 * Created on 2020-07-11 17:37
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyDataInfo.Person person) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                .setName("张三").setAge(20).setAddress("北京").build();
        ctx.channel().writeAndFlush(person);
    }
}