package com.libr.consistent.cache.policy;

import com.libr.consistent.cache.datastructure.DoublyLinkedList;
import com.libr.consistent.cache.datastructure.Node;

import java.util.HashMap;

public class LRUPolicy implements EvictionPolicy {
    DoublyLinkedList order;
    HashMap<Integer, Node> indexing;

    public LRUPolicy() {
        this.order = new DoublyLinkedList();
        this.indexing = new HashMap<Integer, Node>();
    }

    @Override
    public void keyAccessed(int key) {
        if(indexing.get(key) != null) {
            order.erase(this.indexing.get(key));
        }
        this.indexing.put(key, order.addAtTail(key));
    }

    @Override
    public int evictKey() {
        int key = order.get(0);
        this.indexing.put(key, null);
        order.removeAtHead();
        return key;
    }
}

/*


* |1  2  3  2  3|
* 3  2  1
*
*
*
*
*
* */
