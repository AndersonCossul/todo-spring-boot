package com.example.todo.mappers;

import com.example.todo.dtos.TodoDto;
import com.example.todo.models.TodoModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TodoMapper {
    TodoModel toTodoModel(TodoDto todoDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TodoModel toTodoModel(TodoDto todoDto, @MappingTarget TodoModel todoModel);
}
