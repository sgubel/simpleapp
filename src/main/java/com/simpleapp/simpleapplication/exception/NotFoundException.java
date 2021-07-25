package com.simpleapp.simpleapplication.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Entity with id " + id + " not found.");
    }
}
