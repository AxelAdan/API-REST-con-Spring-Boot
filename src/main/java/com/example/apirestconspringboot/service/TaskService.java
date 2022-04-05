package com.example.apirestconspringboot.service;

import com.example.apirestconspringboot.mapper.TaskInDTOToTask;
import com.example.apirestconspringboot.persistence.entities.Task;
import com.example.apirestconspringboot.persistence.repository.TaskRepository;
import com.example.apirestconspringboot.dto.TaskInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);

        return this.repository.save(task);
    }

    public List<Task> getAllTasks() {
        return this.repository.findAll();
    }
}
