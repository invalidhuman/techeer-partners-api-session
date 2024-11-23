package com.example.techeer_partners_api_session.dto;

public class TaskRequestDto {
    // id는 자동으로 생성
    private final String title;
    private final boolean isDone;

    public TaskRequestDto(String title, boolean isDone) {
        this.title = title;
        this.isDone = isDone;
    }
    // dto를 활용할 다른 메서드에서 dto를 활용할 수 있게 만들기
    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return isDone;
    }
}
