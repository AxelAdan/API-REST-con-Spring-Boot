package com.example.apirestconspringboot.service;

import com.example.apirestconspringboot.exceptions.ToDoException;
import com.example.apirestconspringboot.mapper.TaskInDTOToTask;
import com.example.apirestconspringboot.persistence.entities.Task;
import com.example.apirestconspringboot.persistence.entities.TaskStatus;
import com.example.apirestconspringboot.persistence.repository.TaskRepository;
import com.example.apirestconspringboot.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoException("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.marTaskFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoException("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }


}
