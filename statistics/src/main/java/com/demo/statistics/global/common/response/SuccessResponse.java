package com.demo.statistics.global.common.response;

import lombok.Getter;

@Getter
public class SuccessResponse<T> {
    private final T data;

    public SuccessResponse(T data) {
        this.data = data;
    }
}
