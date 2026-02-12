package com.demo.statistics.global.error;

public record ErrorResponse(ErrorDetail error) {

    public static ErrorResponse of(ErrorCode errorCode) {
        return new ErrorResponse(
                new ErrorDetail(errorCode.name(), errorCode.getMessage())
        );
    }

    public record ErrorDetail(String code, String message) {}
}
