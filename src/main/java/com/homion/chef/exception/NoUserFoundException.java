package com.homion.chef.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NoUserFoundException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}
