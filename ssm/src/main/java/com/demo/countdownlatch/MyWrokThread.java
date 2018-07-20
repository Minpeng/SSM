package com.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pengm on 2018/7/20.
 */
public class MyWrokThread implements  Runnable {
    private final CountDownLatch startSignal;

    public MyWrokThread(CountDownLatch startSignal) {
        this.startSignal = startSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await(); //一直阻塞当前线程，直到计时器的值为0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doWork();

    }

    private void doWork() {
        System.out.println(Thread.currentThread().getName()+" do work");
    }



}