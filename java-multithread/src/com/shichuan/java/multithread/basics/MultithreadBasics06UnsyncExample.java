package com.shichuan.java.multithread.basics;

import java.util.concurrent.CountDownLatch;

/**
 * how this work? [Run multiple times to see the different output]
 *   10000 threads do increment
 *   10000 threads do decrement
 * 
 * use CountDownLatch for check the result
 */
public class MultithreadBasics06UnsyncExample {

	private static CountDownLatch l;

	public static void main(String[] args) {
		int N = 2000;
		l = new CountDownLatch(N);
		
		for (int i = 0; i < N / 2; i ++) {
			new Thread(() -> {
				new Process().increment();
			}).start();
		}

		for (int i = 0; i < N / 2; i ++) {
			new Thread(() -> {
				new Process().decrement();
			}).start();
		}

		try {
			l.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Process.cnt);
	}

	
	
	private static class Process {

		public static int cnt = 0;

		// synchronized method
		public synchronized void increment() {
			cnt ++;
			l.countDown();
		}
		// synchronized method
		public synchronized void decrement() {
			cnt --;
			l.countDown();
		}
	}
}


