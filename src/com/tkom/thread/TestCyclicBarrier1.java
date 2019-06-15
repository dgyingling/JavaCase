package com.tkom.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by tkom on 2019/6/15 0015.
 */
public class TestCyclicBarrier1 {

    /*
        多个线程到达屏障之后，同时被唤醒，它们的执行顺序有CPU决定
     */
    static CyclicBarrier barrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("11111");
        });
        thread.start();

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("222222");

    }
    /*
    执行结果为
             11111
             222222
            或
            222222
            11111
     */
}
