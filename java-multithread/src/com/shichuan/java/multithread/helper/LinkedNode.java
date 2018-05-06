package com.shichuan.java.multithread.helper;

public class LinkedNode<T> {
    public T element;
    public LinkedNode<T> next = null;
    public LinkedNode(T e) {
        element = e;
    }
    
    public String toString() {
        return element.toString();
    }
}
