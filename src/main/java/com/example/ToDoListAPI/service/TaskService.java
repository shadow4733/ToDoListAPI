package com.example.ToDoListAPI.service;

import com.example.ToDoListAPI.exceptions.TaskNotFoundException;
import com.example.ToDoListAPI.models.Task;
import com.example.ToDoListAPI.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new
                        TaskNotFoundException("Task not found with id: "+ id));
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updateTask){
        Task task = getTaskById(id);
        task.setTitle(updateTask.getTitle());
        task.setDescription(updateTask.getDescription());
        task.setStatus(updateTask.getStatus());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
