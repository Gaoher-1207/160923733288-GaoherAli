package com.example.task.models;

public class Task {

    private Long taskId;
    private String taskTitle;
    private String taskDetails;
    private String taskStatus; // Optional: replace with TaskState if you use enum

    public Task() {}

    public Task(Long taskId, String taskTitle, String taskDetails, String taskStatus) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDetails = taskDetails;
        this.taskStatus = taskStatus;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
