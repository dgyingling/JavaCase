package com.tkom.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by tkom on 2019/6/16 0016.
 * 摘自：https://blog.csdn.net/XingXing_Java/article/details/91955441
 */
public class TestSemaphore {
    static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        int N = 3;
        Thread[] threads = new Thread[N];
        final Semaphore[] syncObjects = new Semaphore[N];
        //让最后一个信号量可以acquire
        for (int i = 0; i < N; i++) {
            syncObjects[i] = new Semaphore(1);
            if (i != N-1){
                syncObjects[i].acquire();
            }
        }
        for (int i = 0; i < N; i++) {
            //第一个线程使用最后一个信号量（让该线程先执行），第二个线程使用第一个信号量，。。
            final Semaphore lastSemphore = i == 0 ? syncObjects[N - 1] : syncObjects[i - 1];
            final Semaphore curSemphore = syncObjects[i];
            final int index = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            lastSemphore.acquire();
                            System.out.println("thread" + index + ": " + result++);
                            if (result > 100){
                                System.exit(0);
                            }
                            curSemphore.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
    }

}
