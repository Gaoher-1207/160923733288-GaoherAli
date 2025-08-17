package com.example.task.controller;

import com.example.task.models.Task;
import com.example.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> addNewTask(@RequestBody Task taskRequest) {
        Task savedTask = taskService.addTask(taskRequest);
        URI location = URI.create(String.format("/tasks/%d", savedTask.getTaskId()));
        return ResponseEntity.created(location).body(savedTask);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> fetchTaskById(@PathVariable("taskId") Long taskId) {
        Task foundTask = taskService.findTaskById(taskId);
        return (foundTask != null) ? ResponseEntity.ok(foundTask) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> fetchAllTasks() {
        List<Task> tasksList = taskService.retrieveAllTasks();
        return ResponseEntity.ok(tasksList);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> modifyTask(@PathVariable("taskId") Long taskId, @RequestBody Task updatedTask) {
        Task modifiedTask = taskService.modifyTask(taskId, updatedTask);
        return (modifiedTask != null) ? ResponseEntity.ok(modifiedTask) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> removeTask(@PathVariable("taskId") Long taskId) {
        boolean isDeleted = taskService.removeTask(taskId);
        return isDeleted ? ResponseEntity.ok("Task with ID " + taskId + " has been removed")
                : ResponseEntity.notFound().build();
    }
}
