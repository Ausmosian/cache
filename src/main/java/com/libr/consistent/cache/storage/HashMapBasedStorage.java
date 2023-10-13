package com.libr.consistent.cache.storage;


import java.util.HashMap;
import java.util.Map;

import com.libr.consistent.cache.exception.KeyNotFoundException;
import com.libr.consistent.cache.exception.StorageFullException;

public class HashMapBasedStorage implements Storage {
    Map<Integer, Integer> storage;
    private final int capacity;

    public HashMapBasedStorage(int capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void insert(int key, int value) {
        if(isStorageFull()) throw new StorageFullException("Storage is Full!!");
        storage.put(key, value);
    }

    @Override
    public void erase(int key) throws KeyNotFoundException {
        if(!storage.containsKey(key)) throw new KeyNotFoundException("Key not found!!");
        storage.remove(key);
    }

    @Override
    public int get(int key) throws KeyNotFoundException {
        if(!storage.containsKey(key))  throw new KeyNotFoundException("Key not found!!");
        return storage.get(key);
    }

    public boolean isStorageFull() {
        return (storage.size() >= capacity);
    }
}
