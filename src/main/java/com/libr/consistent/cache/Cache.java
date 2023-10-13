package com.libr.consistent.cache;

import com.libr.consistent.cache.exception.KeyNotFoundException;
import com.libr.consistent.cache.exception.StorageFullException;
import com.libr.consistent.cache.policy.EvictionPolicy;
import com.libr.consistent.cache.storage.Storage;

public class Cache {
    private final Storage storage;
    private final EvictionPolicy evictionPolicy;


    public Cache(Storage storage, EvictionPolicy evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(int key, int value) throws KeyNotFoundException {
        if(this.storage.isStorageFull()) {
            int keyToEvict = this.evictionPolicy.evictKey();
            this.storage.erase(keyToEvict);
        }
        this.storage.insert(key, value);
        this.evictionPolicy.keyAccessed(key);
    }

    public int get(int key) throws KeyNotFoundException {
        int value = this.storage.get(key);
        this.evictionPolicy.keyAccessed(key);
        return value;
    }
}
