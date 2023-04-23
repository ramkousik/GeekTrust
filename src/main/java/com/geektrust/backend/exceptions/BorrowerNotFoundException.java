package com.geektrust.backend.exceptions;

public class BorrowerNotFoundException extends RuntimeException {
    public BorrowerNotFoundException(String message) {
        super(message);
    }
}
