package com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
