package com.example.backendtodolist.controller;

import com.example.backendtodolist.domain.Todo;
import com.example.backendtodolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

//    TodoController(TodoService todoService){
//        this.todoService = todoService;
//    }

    @GetMapping("/todos")
    @ResponseBody
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    @ResponseBody
    public Todo createTodos(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }
}
