package com.thoughtworks.capability.gtb.restfulapidesign.Exception;

import org.springframework.http.HttpStatus;

public class BasicException extends Exception {
    private final HttpStatus httpStatus;

    public BasicException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
