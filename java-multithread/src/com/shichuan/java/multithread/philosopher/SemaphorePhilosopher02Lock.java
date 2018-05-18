package com.shichuan.java.multithread.philosopher;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosopher3 implements Runnable {
	Semaphore fork1, fork2;
	Lock lock;
	
	public void init(Semaphore f1, Semaphore f2, Lock l) {
		fork1 = f1; fork2 = f2; lock = l;
	}

	@Override
	public void run() {
		while (true) {
			lock.lock();
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
			
			lock.unlock();
		}
	}

}

public class SemaphorePhilosopher02Lock {

	public static void main(String[] args) {
		// Prepare
		int N = 5;
		Semaphore[] forks = new Semaphore[N];
		Philosopher3[] phs = new Philosopher3[N];
		Lock lock = new ReentrantLock(true);
		// Forks
		for (int i = 0; i < N; i ++) {
			forks[i] = new Semaphore(1);
		}
		// Philosophers
		for (int i = 0; i < N; i ++) {
			phs[i] = new Philosopher3();
			if (i + 1 < N) {
				phs[i].init(forks[i], forks[(i+1) % N], lock);
			} else {
				phs[i].init(forks[(i+1) % N], forks[i], lock);
			}
		}
		
		for (int i = 0; i < N; i ++) {
			new Thread(phs[i]).start();
		}
		
	}

}
