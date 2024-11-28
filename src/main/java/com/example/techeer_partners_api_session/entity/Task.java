package com.example.techeer_partners_api_session.entity;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean isDone = false;

    public Task() {

    }

    public Task(String title,boolean isDone) {
        this.title = title;
        this.isDone = isDone;
    }

    public void update(String title, boolean isDone) {
        this.title = title;
        this.isDone = isDone;
    }

}
