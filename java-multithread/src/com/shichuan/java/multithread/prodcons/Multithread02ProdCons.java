package com.shichuan.java.multithread.prodcons;

import java.util.ArrayList;

import com.shichuan.java.multithread.helper.EmpFactory;
import com.shichuan.java.multithread.helper.Employee;

/**
 * List have limitation of max size (size: N)
 *   producer add item to list (block when list size >= 10)
 *   consumer remove item from list (block when list size == 0)
 */
public class Multithread02ProdCons {
    public static void main(String[] args) {
        int size = 10;
        ArrayList<Employee> arr = new ArrayList<Employee>(size);
        Object lock = new Object();
        Thread t1 = new Thread(new Producer2(size, lock, arr));
        Thread t2 = new Thread(new Consumer2(size, lock, arr));
        t1.start();
        t2.start();
    }
}

class Producer2 implements Runnable {
    int SIZE = 0;
    Object lock = null;
    ArrayList<Employee> emplist = null;
    
    Producer2(int s, Object l, ArrayList<Employee> el) {
        SIZE = s;
        lock = l;
        emplist = el;
    }
    
    public void run() {
        while(true) {
            synchronized(lock) {
                if (emplist.size() < SIZE) {
                    Employee e = EmpFactory.genEmp();
                    emplist.add(e);
                    lock.notify();
                    System.out.printf("Add %03d %s [size:%4d] %s\n", e.empId, e.name, emplist.size(),Thread.currentThread().getName());
                } else {
                    if (emplist.size() > 0)
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

class Consumer2 implements Runnable {
    int SIZE = 0;
    Object lock = null;
    ArrayList<Employee> emplist = null;
    
    Consumer2(int s, Object l, ArrayList<Employee> el) {
        SIZE = s;
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
                    System.out.printf("Rem %03d %s [size:%4d] %s\n", e.empId, e.name, emplist.size(), Thread.currentThread().getName());
                    emplist.remove(e);
                    lock.notify();
                }
            }
        }
    }
}
