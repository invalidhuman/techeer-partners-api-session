package com.example.techeer_partners_api_session.dto;

import com.example.techeer_partners_api_session.entity.Task;

import java.util.List;

public class ApiResponseDto<T> {
    private final String status;
    private final String message;
    private final List<Task> data;

    public ApiResponseDto(String status, String message, List<Task> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<Task> getData() {
        return data;
    }
}
