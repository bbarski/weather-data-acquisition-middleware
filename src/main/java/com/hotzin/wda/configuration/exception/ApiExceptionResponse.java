package com.hotzin.wda.configuration.exception;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.OffsetDateTime;
import java.util.UUID;

@Slf4j
@ToString
@Getter
@Setter
@NoArgsConstructor
public class ApiExceptionResponse {

    private UUID uuid;
    private String message;
    private OffsetDateTime timestamp;

    @Builder
    public ApiExceptionResponse(String message) {
        this.message = message;
        this.timestamp = OffsetDateTime.now();
        this.uuid = UUID.randomUUID();

        log.error(toString());
    }

}
