package com.tkom.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tkom on 2019/6/13 0013.
 */
public class TestThreadLocal {
    /*
    *一个线程可以根据ThreadLocal对象查询到绑定在这个线程上的值
    */
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    
    public static void main(String[] args) {
        ExecutorService threadService = Executors.newFixedThreadPool(5);
        threadService.execute(()->{
            threadLocal.set("1234");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----"+threadLocal.get());
        });
        threadService.execute(()->{
            threadLocal.set("2222");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----"+threadLocal.get());
        });
    }
}
