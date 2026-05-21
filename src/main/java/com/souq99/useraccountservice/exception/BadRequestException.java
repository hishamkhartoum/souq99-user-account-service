package com.souq99.useraccountservice.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String ex){
        super(ex);
    }
}
