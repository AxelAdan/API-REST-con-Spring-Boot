package com.example.apirestconspringboot.controller;

import com.example.apirestconspringboot.dto.TaskInDTO;
import com.example.apirestconspringboot.persistence.entities.Task;
import com.example.apirestconspringboot.persistence.entities.TaskStatus;
import com.example.apirestconspringboot.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status) {
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id) {
        this.taskService.updateTaskFinished(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.taskService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
