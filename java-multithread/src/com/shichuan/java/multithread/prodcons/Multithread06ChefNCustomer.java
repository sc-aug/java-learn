package com.shichuan.java.multithread.prodcons;

import java.util.Random;

/**
 * Scenario: One person is preparing food (Producer) while other 
 * one is serving food (Consumer). Both will use shared table for 
 * putting food plates and taking food plates. Producer which is 
 * the person preparing food will wait if table is full and 
 * Consumer (Person who is serving food) will wait if table is 
 * empty. Implement it ensuring it is thread safe and ensure no 
 * deadlock or any other problem
 */
public class Multithread06ChefNCustomer {
	public static void main(String[] args) {
		new Thread(() -> {
			Test.producer();
		}).start();
		
		new Thread(() -> {
			Test.consumer();
		}).start();
	}
}

class Test {
	static Random r = new Random();
	static Object lock = new Object();
	static boolean food = false;
	
	public static void producer() {
		while (true) {
			synchronized(lock) {
				if (! food) {      // no   food
					System.out.println("chef making food");
					try { Thread.sleep(1000);
					} catch (InterruptedException e) { e.printStackTrace(); }
					
					food = true;   // make food
					lock.notify();
				} else {
					try {
						System.out.println("chef wait customer eat");
						lock.wait();
						System.out.println("chef wait end");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void consumer() {
		while (true) {
			synchronized(lock) {
				if (food) {       // have food
					System.out.println("customer eating food");
					food = false; // eat  food
					System.out.println("customer finish eating");
					lock.notify();
				} else {
					try {
						System.out.println("customer wait chef make food");
						lock.wait();
						System.out.println("customer wait end");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
