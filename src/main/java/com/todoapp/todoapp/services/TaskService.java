package com.todoapp.todoapp.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.todoapp.entities.TaskEntity;
import com.todoapp.todoapp.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity createTask(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public TaskEntity updateTask(Long id, TaskEntity taskEntity) {
        TaskEntity currentTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        if (taskEntity.getTitle() != null) {
            currentTask.setTitle(taskEntity.getTitle());
        }

        if (taskEntity.getDescription() != null) {
            currentTask.setDescription(taskEntity.getDescription());
        }

        if (taskEntity.getCompleted() != null) {
            currentTask.setCompleted(taskEntity.getCompleted());
        }

        currentTask.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(currentTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
