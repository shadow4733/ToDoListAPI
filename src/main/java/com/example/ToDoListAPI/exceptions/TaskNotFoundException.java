package com.example.ToDoListAPI.exceptions;

import com.example.ToDoListAPI.models.Task;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
