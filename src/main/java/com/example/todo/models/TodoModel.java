package com.example.todo.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "todos")
public class TodoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
}
