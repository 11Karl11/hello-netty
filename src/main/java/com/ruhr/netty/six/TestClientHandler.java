package com.ruhr.netty.six;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author karl xie
 * Created on 2020-07-11 17:37
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyDataInfo.MyMessage myMessage) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int i = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;
        if (0 == i) {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder()
                            .setName("张三").setAge(20).setAddress("北京").build())
                    .build();
        } else if (1 == i) {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder()
                            .setName("小狗").setAge(2).build())
                    .build();
        } else {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType)
                    .setCat(MyDataInfo.Cat.newBuilder()
                            .setName("小猫").setCity(11111111).build())
                    .build();
        }


        //
        // MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
        //         .setName("张三").setAge(20).setAddress("北京").build();
        ctx.channel().writeAndFlush(myMessage);
    }
}