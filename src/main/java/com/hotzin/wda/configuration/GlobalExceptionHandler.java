package com.hotzin.wda.configuration;

import com.hotzin.wda.configuration.exception.ApiExceptionResponse;
import com.hotzin.wda.configuration.exception.CityNotFoundException;
import com.hotzin.wda.configuration.exception.ExceptionTypeResolver;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.UnknownHostException;

import static com.hotzin.wda.configuration.exception.ExceptionTypeResolver.UNKNOWN_HOST_EXCEPTION;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({
            CityNotFoundException.class,
            MissingServletRequestParameterException.class
    })
    public ApiExceptionResponse handleBadRequest(Exception ex){
        return ApiExceptionResponse.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({UnknownHostException.class})
    public ApiExceptionResponse handleInternalServerError(Exception ex){
        ExceptionTypeResolver exceptionType = resolveExceptionType(ex);
        return ApiExceptionResponse.builder().message(exceptionType.getErrorMessage()).build();
    }

    private ExceptionTypeResolver resolveExceptionType(Exception ex) {
        switch (ex.getCause().getClass().getSimpleName()) {
            case "UnknownHostException" : return UNKNOWN_HOST_EXCEPTION;
            default: throw new RuntimeException();

        }
    }

}
