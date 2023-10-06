package com.example.adventurexp_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timeStamp", LocalDateTime.now());
        responseBody.put("message", exception.getMessage());

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleGeneralException(Exception exception){
        Map<String, Object> responsBody = new HashMap<>();
        responsBody.put("timeStamp", LocalDateTime.now());
        responsBody.put("message", "An Error has occured: " + exception.getMessage());

        return new ResponseEntity<>(responsBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
