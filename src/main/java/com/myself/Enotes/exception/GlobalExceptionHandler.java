package com.myself.Enotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice ist eine Spezial-Annotation von
// Spring MVC, die eine Klasse als globale „Beratungsschicht“ für Controller markiert.
//Sie erlaubt dir, gemeinsame Logik für alle Controller an einer zentralen Stelle zu bündeln.

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


}
