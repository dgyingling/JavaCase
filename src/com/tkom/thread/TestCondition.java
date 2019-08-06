package com.tkom.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/6/13 0013.
 */
public class TestCondition {

    private class BoundedCondition{
        private Object[] items;
        private int count;
        private Lock lock = new ReentrantLock();
        private Condition notEmpty = lock.newCondition();
        private Condition notFull = lock.newCondition();

        public BoundedCondition(int size){
            items = new Object[size];
        }

        public void add(){
            lock.lock();


        }
    }
}
