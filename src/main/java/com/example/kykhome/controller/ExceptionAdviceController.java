package com.example.kykhome.controller;

import com.example.kykhome.exception.BadRequestException;
import com.example.kykhome.exception.ErrorResponse;
import com.example.kykhome.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse badrequest(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = ErrorResponse.builder().message("").code(400).build();
        e.getFieldErrors().forEach(error -> {
            errorResponse.putFieldValidators(error.getField(), error.getDefaultMessage());
        });

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse notFound(NotFoundException e) {
        return ErrorResponse.builder().message(e.getMessage()).code(404).build();
    }

}

