package com.ruhr.netty_learn.com.xie.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Description TODO
 * @Date 2020/3/1 12:04
 * @Created by xiezw
 */
public class AtomicUpdaterTest {
    public static void main(String[] args) {
        Person person = new Person();
//        for(int i=0;i<10;++i){
//            Thread thread = new Thread(() -> {
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(person.age++);
//            });
//            thread.start();
//        }

        AtomicIntegerFieldUpdater<Person> atomicIntegerFieldUpdater =
                AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicIntegerFieldUpdater.getAndIncrement(person));
            });
            thread.start();


        }
    }

}

class Person {
    volatile int age = 1;
}
