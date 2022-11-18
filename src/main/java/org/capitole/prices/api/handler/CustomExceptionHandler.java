package org.capitole.prices.api.handler;

import org.capitole.prices.api.dto.exception.ExceptionResponseDTO;
import org.capitole.prices.api.exception.client.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static final String INTERNAL_SERVER_ERROR_CODE = "SERVER_ERROR";

     @ExceptionHandler(value = { NotFoundException.class })
     @ResponseStatus(value = HttpStatus.NOT_FOUND)
     public ExceptionResponseDTO handleNotFoundExceptions(NotFoundException ex) {

        return ExceptionResponseDTO.builder()
                .status(ex.STATUS_CODE)
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .build();
    }

    @ExceptionHandler(value = { RuntimeException.class })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseDTO handleGenericRuntimeExceptions(RuntimeException ex) {

        return ExceptionResponseDTO.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .errorCode(INTERNAL_SERVER_ERROR_CODE)
                .build();
    }
}