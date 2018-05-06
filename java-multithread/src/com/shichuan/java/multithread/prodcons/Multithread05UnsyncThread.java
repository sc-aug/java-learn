package com.shichuan.java.multithread.prodcons;

import java.util.*;

/**
 * This is an UNSYNC example
 * IF the 2 threads are synchronized, output should be like
 * 
 *   $$$$$  start $$$$$
 *   some thread ouput here
 *   $$$$$   end  $$$$$
 *
 * You can see the ouput is mixed together, they are not sync
 * 	  TaskE lock on `this`
 *    TaskF lock on `list`
 */
public class Multithread05UnsyncThread {
    
    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        Thread t1 = new Thread(new TaskE(ls));
        Thread t2 = new Thread(new TaskF(ls));
        t1.setName("worker-add-1");
        t2.setName("worker-add-2");
        t1.start();
        t2.start();
    }
}

class TaskE implements Runnable {
    List<String> ls = null;
    TaskE(List<String> l) {
        ls = l;
    }
    public void run() {
        while(true) {
            add();
        }
    }
    public void add() {
        synchronized(this) {
            System.out.println("######## start ########## " + Thread.currentThread().getName());
            try {
                Thread.sleep(23);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ls.add("dummy");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("list size: " + ls.size() + " " + ls.hashCode() + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("######## end   ########## " + Thread.currentThread().getName());
        }
    }
}

class TaskF implements Runnable {
    List<String> ls = null;
    TaskF(List<String> l) {
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
            try {
                Thread.sleep(34);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            System.out.println("list size: " + ls.size() + " "+ ls.hashCode() + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(55);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            System.out.println("$$$$$$$$ end   $$$$$$$$$$ " + Thread.currentThread().getName());
        }
    }
}