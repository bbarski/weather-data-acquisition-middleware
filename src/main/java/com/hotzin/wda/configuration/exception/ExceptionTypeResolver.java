package com.hotzin.wda.configuration.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionTypeResolver {


    UNKNOWN_HOST_EXCEPTION("Could not contact 3rd party service.");

    private String errorMessage;

}
