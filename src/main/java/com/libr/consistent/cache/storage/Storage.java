package com.libr.consistent.cache.storage;

import com.libr.consistent.cache.exception.KeyNotFoundException;
import com.libr.consistent.cache.exception.StorageFullException;

public interface Storage {
    public void insert(int key, int value) throws StorageFullException;
    public void erase(int key) throws KeyNotFoundException;
    public int get(int key) throws KeyNotFoundException;

    public boolean isStorageFull();
}
