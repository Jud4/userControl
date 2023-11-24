package com.edae.users.userControl.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
public class ExceptionModel {
    private HttpStatus httpCode;
    private String message;

    public ExceptionModel() {
    }
}
