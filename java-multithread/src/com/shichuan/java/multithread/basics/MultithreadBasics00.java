package com.shichuan.java.multithread.basics;

/**
 * Creation the threads
 */
public class MultithreadBasics00 {

	private static class Worker extends Thread {
		@Override
		public void run() {
			try { Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		int N = 100;
		for (int i = 0; i < N; i ++) {
			Thread t = new Worker();
			t.start();
		}
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread());
	}

}
