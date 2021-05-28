package com.example.hometask9.errors.controllers;

import com.example.hometask9.dto.ResourceNotFoundExceptionResponse;
import com.example.hometask9.errors.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {


    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ResourceNotFoundExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResourceNotFoundExceptionResponse(e.getMessage()));
    }
}
