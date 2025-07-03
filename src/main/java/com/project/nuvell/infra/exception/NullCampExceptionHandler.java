package com.project.nuvell.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullCampExceptionHandler extends RuntimeException{
    public NullCampExceptionHandler(String message){
        super(message);
    }
}
