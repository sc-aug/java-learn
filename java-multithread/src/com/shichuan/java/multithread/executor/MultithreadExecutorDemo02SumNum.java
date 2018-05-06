package com.shichuan.java.multithread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 5 thread to generate a random number and then the main thread
 * should do the sum of these numbers and print the sum
 */
public class MultithreadExecutorDemo02SumNum {

    public static void main(String[] args) {
        int N = 5, cnt = 0, sum = 0;
        Future[] out = new Future[N];
        ExecutorService ex = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i ++) {
            out[i] = ex.submit(new RandNum());
        }
        
        for (int i = 0; i < N; i ++) {
            try {
                sum += (int) out[i].get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(sum);
    }

    private static class RandNum implements Callable<Object> {
        
        @Override
        public Object call() throws Exception {
            return (int) (Math.random() * 10);
        }
        
    }
}

