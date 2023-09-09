package com.homion.chef.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class Response {
    private HttpStatus status;
    private String message;
    private Object data;
}
