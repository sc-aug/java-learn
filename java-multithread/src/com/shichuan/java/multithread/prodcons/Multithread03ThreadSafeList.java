package com.shichuan.java.multithread.prodcons;

import com.shichuan.java.multithread.helper.*;

public class Multithread03ThreadSafeList {
    public static void main(String[] args) {
        SafedLinkedList<Employee> arr = new SafedLinkedList<Employee>();
        Thread t1 = new Thread(new TaskA(arr));
        Thread t2 = new Thread(new TaskB(arr));
        t1.start();
        t2.start();
//        arr.add(EmpFactory.genEmp());
//        arr.add(EmpFactory.genEmp());
//        arr.add(EmpFactory.genEmp());
//
//        arr.remove(-1);
//        arr.remove(-1);
//        arr.add(EmpFactory.genEmp());
//        LinkedNode<Employee> head = arr.head;
//        System.out.println(arr);
    }
}

class TaskA implements Runnable {
    SafedLinkedList<Employee> list;
    
    public TaskA(SafedLinkedList<Employee> l) {
        list = l;
    }
    
    public void run() {
        while (true) {
            list.add(EmpFactory.genEmp());
        }
    }
}

class TaskB implements Runnable {
    SafedLinkedList<Employee> list;
    
    public TaskB(SafedLinkedList<Employee> l) {
        list = l;
    }
    
    public void run() {
        while (true) {
            System.out.println("remove output: " + list.remove(0));
        }
    }
}
