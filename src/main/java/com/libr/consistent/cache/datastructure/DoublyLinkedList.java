package com.libr.consistent.cache.datastructure;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        Node curr = this.getNode(index);

        if(curr == null) return -1;
        return curr.val;
    }

    public Node getNode(int index) {
        if(index >= this.size) return null;

        Node curr = this.head;
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public Node addAtHead(int val) {
        Node curr = new Node(val);
        if(this.head == null) {
            this.head = curr;
            this.tail = curr;
        }
        else {
            this.head.prev = curr;
            curr.next = this.head;
            this.head = curr;
        }
        this.size++;
        return curr;
    }

    public void removeAtHead() {
        Node curr = this.head;
        if(this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        else {
            this.head = curr.next;
            this.head.prev = null;
            this.size--;
        }
        curr = null;

    }

    public Node addAtTail(int val) {
        Node curr = new Node(val);
        if(this.tail == null) {
            this.tail = curr;
            this.head = curr;
        }
        else {
            this.tail.next = curr;
            curr.prev = this.tail;
            this.tail = curr;
        }
        this.size++;
        return curr;
    }

    public void removeAtTail() {
        Node curr = this.tail;
        if(this.head == this.tail) {
            this.tail = null;
            this.head = null;
            this.size = 0;
        }
        else {
            this.tail = curr.prev;
            this.tail.next = null;
            this.size--;
        }
        curr = null;
    }

    public Node addAtIndex(int index, int val) {
        if(index == 0) {
            return this.addAtHead(val);

        }

        if(index == this.size) {
            return this.addAtTail(val);
        }

        Node curr = this.getNode(index);
        if(curr == null) return null;

        return this.insert(curr.prev, val);
    }

    public void deleteAtIndex(int index) {
        Node curr = this.getNode(index);
        if(curr == null) return;

        this.erase(curr);
    }

    public Node insert(Node before, int val) {
        if(before == this.tail) {
            return this.addAtTail(val);
        }

        Node curr = new Node(val);
        Node after = before.next;

        before.next = curr;
        curr.next = after;
        after.prev = curr;
        curr.prev = before;

        this.size++;
        return curr;
    }

    public void erase(Node curr){
        if(curr == this.head) {
            this.removeAtHead();
        }
        else if(curr == this.tail) {
            this.removeAtTail();
        }
        else {
            Node before = curr.prev;
            Node after = curr.next;
            before.next = after;
            after.prev = before;

            curr = null;
            this.size--;
        }
    }
}