package com.example.todo.services;

import com.example.todo.dtos.TodoDto;
import com.example.todo.mappers.TodoMapper;
import com.example.todo.models.TodoModel;
import com.example.todo.repositories.TodoRepository;
import com.example.todo.responses.TodoDeletedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoService(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    public List<TodoModel> list() {
        return todoRepository.findAll();
    }

    public Optional<TodoModel> byId(int id) {
        Optional<TodoModel> model = todoRepository.findById(id);
        if (model.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found for id " + id);
        }
        return model;
    }


    public TodoModel byName(String name) {
        TodoModel model = todoRepository.findByName(name);
        if (model == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found for name " + name);
        }
        return model;
    }

    public TodoModel create(TodoDto todoDto) {
        return todoRepository.save(todoMapper.toTodoModel(todoDto));
    }

    public TodoModel update(TodoDto todoDto, int id) {
        Optional<TodoModel> model = todoRepository.findById(id);

        if (model.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found for id " + id);
        }

        TodoModel newModel = todoMapper.toTodoModel(todoDto, model.get());
        newModel.setId(id);
        return todoRepository.save(newModel);
    }

    public TodoDeletedResponse delete(int id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            TodoDeletedResponse todoDeletedResponse = new TodoDeletedResponse();
            todoDeletedResponse.setMessage("Todo by id " + id + " was deleted.");
            return todoDeletedResponse;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found for id " + id);
    }
}
