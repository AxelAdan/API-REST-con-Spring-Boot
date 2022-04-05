package com.example.apirestconspringboot.controller;

import com.example.apirestconspringboot.dto.TaskInDTO;
import com.example.apirestconspringboot.persistence.entities.Task;
import com.example.apirestconspringboot.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.taskService.getAllTasks();
    }
}
