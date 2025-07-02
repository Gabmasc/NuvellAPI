package com.project.nuvell.infra.exception.handler;

import com.project.nuvell.infra.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@RestControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomEntityResponseHandler.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
        logger.error("Error interno nao tratado: {} - Path: {}", ex.getMessage(), request.getDescription(false), ex);
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatusCode statusCode,
            WebRequest request){
        String cause = ex.getMostSpecificCause().getMessage();

        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                "Erro no corpo da requisição: " + cause,
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ExceptionResponse> buildResponse(Exception e, WebRequest request, HttpStatus httpStatus) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                e.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(InvalidAgeException.class)
    public final ResponseEntity<ExceptionResponse> invalidAgeException(InvalidAgeException ex, WebRequest request){
        logger.warn("Idade Invalida detectada: {}", ex.getMessage());
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidContactException.class)
    public final ResponseEntity<ExceptionResponse> invalidContactException(InvalidContactException ex, WebRequest request){
        logger.warn("Contato Invalido detectado: {}", ex.getMessage());
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCpfException.class)
    public final ResponseEntity<ExceptionResponse> invalidCpfException(InvalidCpfException ex, WebRequest request){
        logger.warn("Cpf Invalido detectado: {}", ex.getMessage());
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public final ResponseEntity<ExceptionResponse> invalidEmailException(InvalidEmailException ex, WebRequest request){
        logger.warn("Email Invalido detectado: {}", ex.getMessage());
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
