package com.libr.consistent.cache.exception;

public class StorageFullException extends RuntimeException {
    public StorageFullException(String message) {
        super(message);
    }
}
