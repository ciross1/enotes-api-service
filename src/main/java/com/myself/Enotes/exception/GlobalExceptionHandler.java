package com.myself.Enotes.exception;

import com.myself.Enotes.DtoValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// @ControllerAdvice ist eine Spezial-Annotation von
// Spring MVC, die eine Klasse als globale „Beratungsschicht“ für Controller markiert.
//Sie erlaubt dir, gemeinsame Logik für alle Controller an einer zentralen Stelle zu bündeln.

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();

        Map<String, Object> error = new LinkedHashMap<>();

        allErrors.stream().forEach( er->{
            String message =   er.getDefaultMessage();
            String field = ((FieldError) (er)).getField();
            error.put(field, message);
        });

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DtoValidationException.class)
    public ResponseEntity<?>handleValidationException(DtoValidationException e){
        return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
    }



}
