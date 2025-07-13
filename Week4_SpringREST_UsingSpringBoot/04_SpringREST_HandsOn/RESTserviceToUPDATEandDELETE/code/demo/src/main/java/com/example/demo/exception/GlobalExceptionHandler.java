package com.example.demo.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("error", "Bad Request");

        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException cause = (InvalidFormatException) ex.getCause();
            for (InvalidFormatException.Reference ref : cause.getPath()) {
                body.put("message", "Incorrect format for field '" + ref.getFieldName() + "'");
            }
        } else {
            body.put("message", ex.getMessage());
        }

        return new ResponseEntity<>(body, headers, status);
    }
}
