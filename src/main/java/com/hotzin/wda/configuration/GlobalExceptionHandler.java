package com.hotzin.wda.configuration;

import com.hotzin.wda.configuration.exception.ApiExceptionResponse;
import com.hotzin.wda.configuration.exception.CityNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({CityNotFoundException.class})
    public ApiExceptionResponse handleBadRequest(Exception ex) {
        return ApiExceptionResponse.builder().message(ex.getMessage()).build();
    }

}
