package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskBuilder {
    private Long taskId;
    private String title;
    private String description;
    private LocalDate dueDate;
    private PriorityLevel priorityLevel;
    private StatusEnum statusEnum;
    private User assignedUser;
    private Reminder reminder;
    private LocalDate creationDate;
    private LocalDateTime lastModified;

    public Long getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public TaskBuilder(Long taskId, String title, String description, LocalDate dueDate, PriorityLevel priorityLevel) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priorityLevel = priorityLevel;
        statusEnum = StatusEnum.PENDING;
        assignedUser = null;
        reminder = null;
        creationDate = LocalDate.now();
        lastModified = LocalDateTime.now();
    }

    public TaskBuilder setTitle(String title){
        this.title = title;
        return this;
    }

    public TaskBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public TaskBuilder setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
        return this;
    }

    public TaskBuilder setPriority(PriorityLevel priorityLevel){
        this.priorityLevel = priorityLevel;
        return this;
    }

    public TaskBuilder setStatus(StatusEnum status){
        this.statusEnum = status;
        return this;
    }

    public TaskBuilder setAssignedUser(User user){
        this.assignedUser = user;
        return this;
    }

    public TaskBuilder setReminder(Reminder reminder){
        this.reminder = reminder;
        return this;
    }

    public Task build(){
        return new Task(this);
    }

}
