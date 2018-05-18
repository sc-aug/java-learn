package com.shichuan.java.multithread.philosopher;

import java.util.concurrent.Semaphore;

class Philosopher2 implements Runnable {
	Semaphore fork1, fork2;
	
	public void initFork(Semaphore f1, Semaphore f2) {
		fork1 = f1; fork2 = f2;
	}

	@Override
	public void run() {
		while (true) {
			// Left fork
			try {
				fork1.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " left fork");
			
			// Right fork
			try {
				fork2.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " right fork");

			try {
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// fork release
			fork1.release();
			fork2.release();
		}
	}

}

public class SemaphorePhilosopher01Starvation {

	public static void main(String[] args) {
		// Prepare
		int N = 5;
		Semaphore[] forks = new Semaphore[N];
		Philosopher2[] phs = new Philosopher2[N];
		// Forks
		for (int i = 0; i < N; i ++) {
			forks[i] = new Semaphore(1);
		}
		// Philosophers
		for (int i = 0; i < N; i ++) {
			phs[i] = new Philosopher2();
			if (i + 1 < N) {
				phs[i].initFork(forks[i], forks[(i+1) % N]);
			} else {
				phs[i].initFork(forks[(i+1) % N], forks[i]);
			}
		}
		
		for (int i = 0; i < N; i ++) {
			new Thread(phs[i]).start();
		}
		
	}

}
