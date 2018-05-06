package com.shichuan.java.multithread.basics;

import java.util.Scanner;

/**
 * Volatile
 *   prevent cpu cache
 *   guarantees variables stored in main memory
 *   guarantees visibility of changes to variables across threads
 */
public class MultithreadBasics03Volatile {
	
	private static class Worker extends Thread {
		private boolean sign = true;
		
		@Override
		public void run() {
			while (sign) {
				long tmp = (long) (Math.random() * 1000);

				System.out.println("sleep " + tmp);
				try { Thread.sleep(tmp);
				} catch (InterruptedException e) { e.printStackTrace(); }
				
			}
		}
		
		public void shutdown() {
			sign = false;
		}
	}

	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.start();
		new Scanner(System.in).nextLine();
		worker.shutdown();
	}

}
