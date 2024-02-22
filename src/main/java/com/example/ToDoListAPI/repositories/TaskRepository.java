package com.example.ToDoListAPI.repositories;

import com.example.ToDoListAPI.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByStatus(String completed);

    List<Task> findByTitleContainingIgnoreCase(String keyword);

}
