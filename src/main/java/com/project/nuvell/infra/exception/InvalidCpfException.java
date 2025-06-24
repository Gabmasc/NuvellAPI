package com.project.nuvell.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCpfException extends RuntimeException{
    public InvalidCpfException(String message){
        super(message);
    }
}
