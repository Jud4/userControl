package com.edae.users.userControl.exceptions;

import com.edae.users.userControl.exceptions.model.ExceptionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadArgsException.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ExceptionModel exceptionModel = new ExceptionModel(HttpStatus.BAD_REQUEST,"An Exception have occurred: "+ex.getMessage());
        return handleExceptionInternal(ex, exceptionModel,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
