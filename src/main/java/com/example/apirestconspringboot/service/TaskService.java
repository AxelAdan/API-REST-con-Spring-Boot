package com.example.apirestconspringboot.service;

import com.example.apirestconspringboot.persistence.entities.Task;
import com.example.apirestconspringboot.persistence.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        
    }
}
