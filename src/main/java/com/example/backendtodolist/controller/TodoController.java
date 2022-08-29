package com.example.backendtodolist.controller;

import com.example.backendtodolist.domain.Todo;
import com.example.backendtodolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

//    TodoController(TodoService todoService){
//        this.todoService = todoService;
//    }

    @PostMapping("/todos")
    @ResponseBody
    public Todo createTodos(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }
}
