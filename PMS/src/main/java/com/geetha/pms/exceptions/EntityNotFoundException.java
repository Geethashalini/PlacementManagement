package com.geetha.pms.exceptions;

/**
 * Custom exception class for handling entity not found exceptions.
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
