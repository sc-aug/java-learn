package com.shichuan.java.multithread.basics;

/**
 * Scenario: two threads access one resource (`cnt`)
 *   make the increment method synchronized
 */
public class MultithreadBasics04SyncMethod {

	private static int cnt = 0;

	public static void main(String[] args) {
		work();
		System.out.println(cnt);
	}
	
	// synchronized method
	private synchronized static void increment() {
		cnt ++;
	}

	private static void work() {
		int N = 50000;
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < N; i ++) increment();
		});
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < N; i ++) increment();
		});
		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
