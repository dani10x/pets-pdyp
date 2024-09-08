package com.example.pets.exception;

import static java.text.MessageFormat.format;

public class DataException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataException(String message, Object... parametros) {
        super(format(message, parametros));
    }
}
