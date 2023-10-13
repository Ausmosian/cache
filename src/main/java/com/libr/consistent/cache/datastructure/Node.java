package com.libr.consistent.cache.datastructure;

public class Node {
    public Integer val;
    public Node prev;
    public Node next;

    public Node() {
        this.val = 0;
        this.prev = null;
        this.next = null;
    }

    public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
