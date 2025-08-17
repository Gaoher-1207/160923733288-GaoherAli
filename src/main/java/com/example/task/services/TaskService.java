package com.example.task.services;

import com.example.task.models.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    private final Map<Long, Task> taskStorage = new HashMap<>();
    private long idSequence = 1;

    public Task addTask(Task newTask) {
        newTask.setTaskId(idSequence++);
        taskStorage.put(newTask.getTaskId(), newTask);
        return newTask;
    }

    public Task findTaskById(Long taskId) {
        return taskStorage.get(taskId);
    }

    public List<Task> retrieveAllTasks() {
        return new ArrayList<>(taskStorage.values());
    }

    public Task modifyTask(Long taskId, Task updatedTask) {
        if (taskStorage.containsKey(taskId)) {
            updatedTask.setTaskId(taskId);
            taskStorage.put(taskId, updatedTask);
            return updatedTask;
        }
        return null;
    }

    public boolean removeTask(Long taskId) {
        return taskStorage.remove(taskId) != null;
    }
}
