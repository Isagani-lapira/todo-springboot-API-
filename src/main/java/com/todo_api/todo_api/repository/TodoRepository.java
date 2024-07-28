package com.todo_api.todo_api.repository;

import com.todo_api.todo_api.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {

    List<Todo> findByUsername(String username);
}
