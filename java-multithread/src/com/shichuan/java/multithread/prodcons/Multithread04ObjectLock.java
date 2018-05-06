package com.shichuan.java.multithread.prodcons;

import java.util.*;

/**
 * Synchronized block
 * 	 2 threads add item to list,
 *   2 threads remove item from list
 */
public class Multithread04ObjectLock {
    
    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        Thread t1 = new Thread(new TaskAdd(ls));
        Thread t2 = new Thread(new TaskAdd(ls));
        Thread t3 = new Thread(new TaskRem(ls));
        Thread t4 = new Thread(new TaskRem(ls));
        t1.setName("worker-add-1");
        t2.setName("worker-add-2");
        t3.setName("worker-rem-3");
        t4.setName("worker-rem-4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class TaskAdd implements Runnable {
    List<String> ls = null;
    TaskAdd(List<String> l) {
        ls = l;
    }
    public void run() {
        while(true) {
            add();
        }
    }
    public void add() {
        synchronized(ls) {
            System.out.println("######## start ########## " + Thread.currentThread().getName());
            
            ls.add("dummy");

            System.out.println("list size: " + ls.size() + " " + ls.hashCode() + " " + Thread.currentThread().getName());

            System.out.println("######## end   ########## " + Thread.currentThread().getName());
        }
    }
}

class TaskRem implements Runnable {
    List<String> ls = null;
    TaskRem(List<String> l) {
        ls = l;
    }
    public void run() {
        while(true) {
            remove();
        }
    }
    public void remove() {
        synchronized(ls) {
            try {
                Thread.sleep(13);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            System.out.println("$$$$$$$$ start $$$$$$$$$$ " + Thread.currentThread().getName());
            if (ls.size() != 0) ls.remove(0);
            else System.out.println("Fail to remove.");
            
            System.out.println("list size: " + ls.size() + " "+ ls.hashCode() + " " + Thread.currentThread().getName());
            
            System.out.println("$$$$$$$$ end   $$$$$$$$$$ " + Thread.currentThread().getName());
        }
    }
}