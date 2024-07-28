package com.todo_api.todo_api.controller.api;


import com.todo_api.todo_api.model.Todo;
import com.todo_api.todo_api.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoControllerAPI {

    private final TodoService service;

    public TodoControllerAPI(TodoService service) {
        this.service = service;
    }

    @GetMapping("/hello-world")
    public String getHelloWorld(){
        return "Hello beginners";
    }

    @GetMapping("/auth")
    public String authentication(){
        return "Hello beginners";
    }

    @GetMapping("/task-list")
    public Todo getTaskList(){
        return new Todo(1001,"isagani","pogi", LocalDate.now(),false);
    }

    @GetMapping("/task-list/{username}")
    public List<Todo> getUserTask(@PathVariable String username){
        return service.getUserTask(username);
    }
    @GetMapping("/task/{id}")
    public Optional<Todo> getNewTask(@PathVariable int id){
        return service.getNewTask(id);
    }

    @DeleteMapping("/task-list/remove/{id}")
    public ResponseEntity<Todo> removeTask(@PathVariable int id){
        service.removeUserTask(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add-task")
    public ResponseEntity<Todo> addNewTask(@RequestBody Todo todo){
        Todo newlyAddTask = service.addNewTask(todo);
        URI locationOfNewTask = ServletUriComponentsBuilder
                .fromPath("/task/{id}")
                .buildAndExpand(newlyAddTask.getId())
                .toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(locationOfNewTask).build();
    }

    @PutMapping("/update-task")
    public void updateTask(@RequestBody Todo todo){
        service.updateTask(todo);
    }
}
