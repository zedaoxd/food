package com.food.service.exception;

public class DatabaseException extends RuntimeException
{
    public DatabaseException(String message) {
        super(message);
    }
}
