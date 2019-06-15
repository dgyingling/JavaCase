package com.tkom.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by tkom on 2019/6/15 0015.
 */
public class TestCountDownLatch {
    /*
    CountDownLatch是await的线程等待计数为0时继续执行
     */
    static CountDownLatch latch = new CountDownLatch(3);
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            latch.countDown();
            System.out.println("1111");
        });
        Thread thread2 = new Thread(()->{
            latch.countDown();
            System.out.println("222222");
        });
        thread1.start();
        thread2.start();
        try {
            latch.await(5, TimeUnit.SECONDS);  //等待5秒后,继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("33333");
    }
}
