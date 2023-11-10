package com.codewithkv.springbootjpa.Controller;

import com.codewithkv.springbootjpa.Model.Todo;
import com.codewithkv.springbootjpa.Service.TodoService;
import com.codewithkv.springbootjpa.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/all/{userId}")
    public List<Todo> findAll(@PathVariable int userId) {

        return todoService.getAllItems(userId);
    }
    @GetMapping("/all")
    public  List<Todo> findTodo(){
        return todoService.getItems();
    }


    @PostMapping
    public List<Todo> createTodo(@RequestBody TodoRequest todoRequest) {

        return todoService.createTodo(todoRequest);
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.updateTodo(todoRequest);
    }

    @DeleteMapping("/delete/{id}")
    public List<Todo> deleteTodoById(@PathVariable Integer id) {
        return todoService.deleteTodoById(id);

    }
}
