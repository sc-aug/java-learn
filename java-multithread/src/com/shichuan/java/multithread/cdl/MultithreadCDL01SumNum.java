package com.shichuan.java.multithread.cdl;

import java.util.concurrent.CountDownLatch;

public class MultithreadCDL01SumNum {

    public static void main(String[] args) {
        int[] sum = new int[]{ 0 };
        int N = 5;
        CountDownLatch l = new CountDownLatch(N);
        Object obj = new Object();

        for (int i = 0; i < N; i ++) {
            new Thread(new RandNum(sum, l, obj)).start();
        }

        // Waiting countdown
        try {
            l.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sum[0]);
    }

    private static class RandNum implements Runnable {
        CountDownLatch l;
        int[] s = null;
        Object lock = null;

        public RandNum(int[] sum, CountDownLatch latch, Object lock) {
            s = sum;
            l = latch;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized(lock) {
                s[0] += (int) (Math.random() * 10);
                l.countDown();
            }
        }

    }

}