package com.example.todo.repositories;

import com.example.todo.models.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Integer> {
    TodoModel findByName(String name);
}
