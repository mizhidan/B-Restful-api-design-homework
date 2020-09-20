package com.thoughtworks.capability.gtb.restfulapidesign.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BasicException.class)
    public ResponseEntity<ErrorException> businessBasicExceptionHandler(BasicException businessBasicException) {
        return new ResponseEntity<>(ErrorException.builder().errorMessage(businessBasicException.getMessage()).build(),
                businessBasicException.getHttpStatus());
    }
}
