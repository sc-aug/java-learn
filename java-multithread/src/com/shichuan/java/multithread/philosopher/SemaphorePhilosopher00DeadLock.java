package com.shichuan.java.multithread.philosopher;

import java.util.concurrent.Semaphore;

class Philosopher1 implements Runnable {
	Semaphore forkLeft, forkRight;
	
	public void initFork(Semaphore l, Semaphore r) {
		forkLeft = l; forkRight = r;
	}

	@Override
	public void run() {
		while (true) {
			// Left fork
			try {
				forkLeft.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " left fork");
			
			// Right fork
			try {
				forkRight.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " right fork");
			
			// fork release
			forkLeft.release();
			forkRight.release();
		}
	}

}

public class SemaphorePhilosopher00DeadLock {

	public static void main(String[] args) {
		// Prepare
		int N = 5;
		Semaphore[] forks = new Semaphore[N];
		Philosopher1[] phs = new Philosopher1[N];
		// Forks
		for (int i = 0; i < N; i ++) {
			forks[i] = new Semaphore(1);
		}
		// Philosophers
		for (int i = 0; i < N; i ++) {
			phs[i] = new Philosopher1();
			phs[i].initFork(forks[i], forks[(i+1) % N]);
		}
		
		for (int i = 0; i < N; i ++) {
			new Thread(phs[i]).start();
		}
		
	}

}
