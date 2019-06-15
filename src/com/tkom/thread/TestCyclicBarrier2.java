package com.tkom.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by tkom on 2019/6/15 0015.
 */
public class TestCyclicBarrier2 {

    static CyclicBarrier barrier = new CyclicBarrier(2, ()->{
        System.out.println("两个线程都到达屏障时，先执行该线程，之后唤醒两个等待的线程");
    });
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("thread到达屏障");
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

        System.out.println("main thread到达屏障");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("22222");
    }
    /*(执行结果)
    main thread到达屏障
    thread到达屏障
    两个线程都到达屏障时，先执行该线程，之后唤醒两个等待的线程
    11111
    22222
     */
}
