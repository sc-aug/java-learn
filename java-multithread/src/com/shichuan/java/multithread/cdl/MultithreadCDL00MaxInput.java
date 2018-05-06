package com.shichuan.java.multithread.cdl;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 * generate N number, print the max number
 */
public class MultithreadCDL00MaxInput {

    public static void main(String[] args) {
        int[] max = new int[]{ 0 };
        int N = 10;
        CountDownLatch l = new CountDownLatch(N);

        for (int i = 0; i < N; i ++) {
            new Thread(new RandNum(max, l, new Object())).start();
        }

        // Waiting countdown
        try {
            l.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(max[0]);
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
            int n = (int) (Math.random() * 10);
            synchronized(lock) {
                s[0] = s[0] > n ? s[0] : n;
            }
            l.countDown();
        }

    }

}
