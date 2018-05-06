package com.shichuan.java.multithread.helper;

public class SafedLinkedList<T> {
    private int cnt = 0;
    
    public LinkedNode<T> head = null;
    
    public SafedLinkedList() {}
    
    private void initHeadNode(T e) {
        head = new LinkedNode<T>(e);
        cnt = 0;
    }
    
    private LinkedNode<T> getLastNode() {
        if (cnt == 0) return null;
        LinkedNode<T> last = head;
        while (last != null && last.next != null) {
            last = last.next;
        }
        return last;
    }
    
    public synchronized int size() {
        return cnt;
    }
    
    public synchronized void add(T e) {
        // output
        System.out.println("A: " + e);
        if (cnt == 0) {
            initHeadNode(e);
        } else {
            LinkedNode<T> l = getLastNode();
            l.next = new LinkedNode<T>(e);
        }
        cnt += 1;
    }
    
    public synchronized boolean remove(int idx) {
        if (idx < 0) idx = idx + cnt;
        if (cnt < idx + 1) {
            return false;
        } else {
            cnt -= 1;
            if (idx == 0) {
                System.out.println("R: " + head.element);
                head = head.next;
                return true;
            } else {
                LinkedNode<T> nodeLast = head;
                for (int i = 0; i < idx-1; i ++)
                    nodeLast = nodeLast.next;
                System.out.println("R: " + nodeLast.next.element);
                LinkedNode<T> nodeTail = nodeLast.next.next;
                nodeLast.next = nodeTail;
                return true;
            }
        }
    }
    
    public synchronized String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedNode<T> cur = head;
        while (cur != null) {
            sb.append(" - " + cur.toString());
            cur = cur.next;
        }
        return sb.toString();
    }
}
