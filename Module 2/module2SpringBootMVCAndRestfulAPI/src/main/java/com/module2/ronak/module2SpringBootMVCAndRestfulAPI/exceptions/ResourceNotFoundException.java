package com.module2.ronak.module2SpringBootMVCAndRestfulAPI.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
