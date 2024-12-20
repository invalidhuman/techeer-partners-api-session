package com.example.techeer_partners_api_session.dto;

import com.example.techeer_partners_api_session.entity.Task;

import java.util.List;

public class TaskResponseDto {
    private final Long id;
    private final String title;
    private final boolean isDone;

    public TaskResponseDto(Long id, String title, boolean isDone) {
        this.id = id;
        this.title= title;
        this. isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsDone() {
        return isDone;
    }
}
