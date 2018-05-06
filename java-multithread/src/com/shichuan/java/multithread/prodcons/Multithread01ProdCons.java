package com.shichuan.java.multithread.prodcons;

import java.util.ArrayList;

import com.shichuan.java.multithread.helper.*;

/**
 * Two thread access a List. The List has capacity of 1
 *    1 thread add an object to list
 *    1 thread remove an object from list
 *    
 * Synchronized block: Object lock
 */
public class Multithread01ProdCons {

	public static void main(String[] args) {
		ArrayList<Employee> arr = new ArrayList<Employee>();
		Object lock = new Object();
		Thread t1 = new Thread(new Producer1(lock, arr));
		Thread t2 = new Thread(new Consumer1(lock, arr));
		t1.start();
		t2.start();
	}


	private static class Producer1 implements Runnable {
		Object lock = null;
		ArrayList<Employee> emplist = null;

		Producer1(Object l, ArrayList<Employee> el) {
			lock = l;
			emplist = el;
		}

		public void run() {
			while(true) {
				synchronized(lock) {
					if (emplist.size() == 0) {
						Employee e = EmpFactory.genEmp();
						emplist.add(e);
						lock.notify();
						System.out.println("Add " + e.empId + " " + e.name);
						try {
							lock.wait();
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					} else {
						lock.notify();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	private static class Consumer1 implements Runnable {
		Object lock = null;
		ArrayList<Employee> emplist = null;

		Consumer1(Object l, ArrayList<Employee> el) {
			lock = l;
			emplist = el;
		}

		public void run() {
			while(true) {
				synchronized(lock) {
					if (emplist.size() == 0) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						Employee e = emplist.get(0);
						System.out.println("Rem " + e.empId + " " + e.name);
						emplist.remove(e);
						lock.notify();
					}
				}
			}
		}
	}
}


