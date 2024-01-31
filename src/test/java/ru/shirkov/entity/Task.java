package ru.shirkov.entity;

import org.springframework.context.annotation.Bean;


public class Task {
    private String description;
    private Status status;

    public Task(String description, Status status) {
        this.description = description;
        this.status = status;
    }
}
