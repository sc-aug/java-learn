package com.shichuan.java.multithread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadExecutorDemo01 {

	public static void main(String[] args) {
		final int TOTAL = 10;
		ExecutorService exec = Executors.newFixedThreadPool(TOTAL);
		
		for (int i = 0; i < TOTAL; i ++) {
			exec.submit(new Thread(() -> {
				System.out.println(Thread.currentThread().getName());
			}));
		}
		exec.shutdown();
	}

}
