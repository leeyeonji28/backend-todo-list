package com.example.backendtodolist.service;

import com.example.backendtodolist.dao.TodoRepository;
import com.example.backendtodolist.domain.Todo;
import com.example.backendtodolist.dto.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        Todo newTodo = new Todo();
        newTodo.setContent(todo.getContent());
        newTodo.setChecked(false);
        todoRepository.save(newTodo);

        return newTodo;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public void deleteTodo(Integer id, HttpServletResponse response) throws IOException {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()){
            todoRepository.deleteById(id);
        } else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setCode("F-1");
            responseDTO.setMessage("해당 할 일은 이미 삭제되었습니다.");
            response.setStatus(404);
            response.setHeader("content-type", "application/json;Charset=utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(response.getOutputStream(), responseDTO);
        }
    }
}
