package com.example.backendtodolist.controller;

import com.example.backendtodolist.domain.Todo;
import com.example.backendtodolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/todos")
@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

//    TodoController(TodoService todoService){
//        this.todoService = todoService;
//    }

    @GetMapping("")
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }

    @PostMapping("")
    public List<Todo> createTodos(@RequestBody Todo todo){
        todoService.createTodo(todo);
        return todoService.getTodos();
    }

    @DeleteMapping("/{id}")
    public List<Todo> deleteTodos(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        todoService.deleteTodo(id, response);
        return todoService.getTodos();
    }
}
