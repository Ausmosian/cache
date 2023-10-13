package com.libr.consistent.cache.policy;

public interface EvictionPolicy {
    public void keyAccessed(int key);
    public int evictKey();
}
