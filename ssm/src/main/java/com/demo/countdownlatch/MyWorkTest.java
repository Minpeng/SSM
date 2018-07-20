package com.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pengm on 2018/7/20.
 */
public class MyWorkTest {
    public static void main(String[] args) {
        CountDownLatch start=new CountDownLatch(1);// 初始化计数器为 一
        for(int i=0;i<16;i++){//模擬16个线程
            MyWrokThread tt =new MyWrokThread(start);
            Thread t = new Thread(tt);

            t.start();

            System.out.println(Thread.currentThread().getName()+"准备work");
        }
        System.out.println("休息一会...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        start.countDown();//计数器減一  所有线程释放 同时跑
    }

}