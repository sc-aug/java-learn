package com.shichuan.java.multithread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MultithreadExecutorDemo00 {

	public static void main(String[] args) {
		final int TOTAL = 10;
		Executor exec = Executors.newFixedThreadPool(TOTAL);
		
		for (int i = 0; i < TOTAL; i ++) {
			exec.execute(new Thread(() -> {
				System.out.println(Thread.currentThread().getName());
			}));
		}
		System.exit(0);
	}
}
