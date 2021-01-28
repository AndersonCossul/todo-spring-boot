package com.example.todo.controllers;

import com.example.todo.dtos.TodoDto;
import com.example.todo.models.TodoModel;
import com.example.todo.responses.TodoDeletedResponse;
import com.example.todo.services.TodoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public List<TodoModel> list() {
        return todoService.list();
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<TodoModel> byId(@PathVariable("id") int id) {
        return todoService.byId(id);
    }

    @GetMapping("/find-by-name/{name}")
    public TodoModel byName(@PathVariable("name") String name) {
        return todoService.byName(name);
    }

    @PostMapping("/create")
    @Transactional
    public TodoModel create(@RequestBody TodoDto todoDto) {
        return todoService.create(todoDto);
    }

    @PatchMapping("/update/{id}")
    public TodoModel update(@RequestBody TodoDto todoDto, @PathVariable("id") int id) {
        return todoService.update(todoDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public TodoDeletedResponse delete(@PathVariable("id") int id) {
        return todoService.delete(id);
    }
}
