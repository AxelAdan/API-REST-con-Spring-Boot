package com.example.apirestconspringboot.persistence.repository;

import com.example.apirestconspringboot.persistence.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
