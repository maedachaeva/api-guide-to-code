package com.demo.statistics.global.common.response;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final ErrorDetail error;

    public ErrorResponse(String code, String message) {
        this.error = new ErrorDetail(code, message);
    }
}
