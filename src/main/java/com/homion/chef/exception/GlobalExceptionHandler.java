package com.homion.chef.exception;

import com.homion.chef.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception exception) {
        log.debug("In exception handler");
        return Response.builder().message(exception.getMessage()).status(HttpStatus.BAD_REQUEST).build();
    }
}
