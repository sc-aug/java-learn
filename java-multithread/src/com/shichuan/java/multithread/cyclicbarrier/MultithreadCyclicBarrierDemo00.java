package com.shichuan.java.multithread.cyclicbarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class MultithreadCyclicBarrierDemo00 {

    public static void main(String[] args) {
        int TOTAL = 1002;
        int N = 4;
        CyclicBarrier cb = new CyclicBarrier(N);
        CountDownLatch latch = new CountDownLatch(TOTAL);
        Object lock = new Object();
        
        for (int i = 0; i < TOTAL; i ++) {
            new Thread(new Cabbing(cb, latch, lock)).start();
        }
        
        // Waiting countdown
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Cabbing.cntPas);
    }
}

class Cabbing implements Runnable {
    static int cntCab = 0;
    static int cntPas = 0;
    CyclicBarrier cb = null;
    CountDownLatch latch = null;
    Object lock = null;
    
    public Cabbing(CyclicBarrier cb, CountDownLatch l, Object lock) {
        this.cb = cb;
        this.latch = l;
        this.lock = lock;
    }
    
    public void run() {
        try {
            Thread.sleep(400);
            if (cb.await(1000, TimeUnit.MILLISECONDS) == 0) {
                synchronized(lock) {
                    cntCab ++;
                    System.out.println(cntCab + " cab go ... "
                            + Thread.currentThread().getName() + " :" + cntCab);
                }
            }
            
            // Count Down 
            latch.countDown();
            
            synchronized(lock) {
                cntPas ++;
                System.out.println("Passenger cnt " + cntPas);
            }
        } catch (Exception e) {
            
        }
    }
}
