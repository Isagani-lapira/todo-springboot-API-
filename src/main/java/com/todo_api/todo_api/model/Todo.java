package com.todo_api.todo_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String task;
    private LocalDate taskDeadline;
    private boolean status;


    Todo(){}
    public Todo(int id,String username, String task, LocalDate taskDeadline, boolean status) {
        this.username = username;
        this.task = task;
        this.taskDeadline = taskDeadline;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", task='" + task + '\'' +
                ", taskDeadline=" + taskDeadline +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

}
