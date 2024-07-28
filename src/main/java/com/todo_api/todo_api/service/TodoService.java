package com.todo_api.todo_api.service;

import com.todo_api.todo_api.model.Todo;
import com.todo_api.todo_api.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository repository;
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getUserTask(String username){
        return repository.findByUsername(username);
    }

    public void removeUserTask(int id){
        if(repository.existsById(id))
            repository.deleteById(id);

    }

    public Todo addNewTask(Todo todo){
        return repository.save(todo);
    }

    public void updateTask(Todo todo){
        repository.save(todo);
    }

    public Optional<Todo> getNewTask(int id){
        return repository.findById(id);
    }
}
