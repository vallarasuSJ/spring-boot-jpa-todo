package com.codewithkv.springbootjpa.Service;

import com.codewithkv.springbootjpa.Model.AppUser;
import com.codewithkv.springbootjpa.Model.Todo;
import com.codewithkv.springbootjpa.Repository.TodoRepository;
import com.codewithkv.springbootjpa.Repository.UserRepository;
import com.codewithkv.springbootjpa.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Todo> getAllItems(int userId) {
        return todoRepository.findAll().stream().filter(todo -> todo.getAppUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> createTodo(TodoRequest todoRequest) {
        Todo originalTodo = new Todo();
        originalTodo.setItem(todoRequest.getItem());
        AppUser user = userRepository.findById(todoRequest.getUserId()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return getAllItems(todoRequest.getUserId());
    }

    public List<Todo> updateTodo(TodoRequest todo) {
        Todo originalTodo=new Todo();
        originalTodo.setId(todo.getId());
        originalTodo.setItem(todo.getItem());
        AppUser user=userRepository.findById(todo.getUserId()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return getAllItems(todo.getUserId());
    }

    public List<Todo> deleteTodoById(Integer id) {
        int userId=todoRepository.findById(id).get().getAppUser().getId();
        todoRepository.deleteById(id);
        return getAllItems(userId);
    }

    public List<Todo> getItems() {
        return todoRepository.findAll();
    }
}
