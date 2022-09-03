package com.example.backendtodolist.controller;

import com.example.backendtodolist.domain.Todo;
import com.example.backendtodolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/todos")
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

    // @PutMapping // 전체적인 업데이트
    @PatchMapping("/{id}") // 일부 수정
    public List<Todo> CheckTodo(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
        todoService.checkTodo(id, response);
        return todoService.getTodos();
    }

    @PatchMapping("/edit/{id}")
    public List<Todo> editTodoById(@PathVariable("id") Integer id, @RequestBody Map<String, Object> params, HttpServletResponse response) throws IOException{
        System.out.println("id + content : " + id + params.get("content"));
        todoService.editTodoById(id, params.get("content"), response);
        return todoService.getTodos();
    }
}
