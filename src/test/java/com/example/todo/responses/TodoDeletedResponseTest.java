package com.example.todo.responses;

import org.junit.jupiter.api.Test;

class TodoDeletedResponseTest {

    @Test
    public void testConstructor() {
        TodoDeletedResponse todoDeletedResponse = new TodoDeletedResponse(1);
        assert todoDeletedResponse.getMessage().equals("TODO by id 1 was deleted.");
    }
}