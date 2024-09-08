package com.example.pets.configuration;

import com.example.pets.dto.Mensaje;
import com.example.pets.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataException.class)
    public ResponseEntity<Mensaje> handleDatoInvalidoException(DataException e) {
        Mensaje error = Mensaje.builder().respuesta(e.getMessage()).error(true).build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
