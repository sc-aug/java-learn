package com.shichuan.java.multithread.basics;

import java.util.concurrent.CountDownLatch;

/**
 * how this work? [Run multiple times to see the different output]
 *   10000 threads do increment
 *   10000 threads do decrement
 * 
 * use CountDownLatch for check the result
 */
public class MultithreadBasics05SyncMethod {

	private static CountDownLatch l;

	public static void main(String[] args) {
		int N = 200;
		l = new CountDownLatch(N);
		Proc p = new Proc(l);
		
		for (int i = 0; i < N / 2; i ++) {
			new Thread(() -> {
				p.increment();
			}).start();
		}

		for (int i = 0; i < N / 2; i ++) {
			new Thread(() -> {
				p.decrement();
			}).start();
		}

		try {
			l.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Proc.cnt);
	}

}

class Proc {
	private CountDownLatch l;
	
	public static int cnt = 0;
	
	public Proc(CountDownLatch l) {
		this.l = l;
	}

	// synchronized method
	public synchronized void increment() {
		cnt = cnt + 1;
		l.countDown();
	}
	// synchronized method
	public synchronized void decrement() {
		cnt = cnt - 1;
		l.countDown();
	}
}
