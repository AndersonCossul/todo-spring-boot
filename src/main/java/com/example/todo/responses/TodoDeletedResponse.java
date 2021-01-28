package com.example.todo.responses;

import lombok.Data;

@Data
public class TodoDeletedResponse {
    private String message;

    public TodoDeletedResponse(int id) {
        message = String.format("TODO by id %s was deleted.", id);
    }
}
