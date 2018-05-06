package com.shichuan.java.multithread.basics;

/**
 * Creation the threads
 *   - anonymous class
 */
public class MultithreadBasics02 {

	public static void main(String[] args) {
		int N = 100;
		for (int i = 0; i < N; i ++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try { Thread.sleep(1000);
					} catch (InterruptedException e) { e.printStackTrace(); }
					System.out.println(Thread.currentThread().getName());
				}
			}).start();
		}
	}

}
