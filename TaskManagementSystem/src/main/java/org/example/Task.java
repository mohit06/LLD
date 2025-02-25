package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(taskId, task.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(taskId);
    }

    public void updateTask(Task task){
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
        this.priorityLevel = task.getPriorityLevel();
        this.statusEnum = task.getStatusEnum();
        this.assignedUser = task.getAssignedUser();
        this.reminder = task.getReminder();
        this.lastModified = task.getLastModified();
    }

    public LocalDateTime getLastModified(){
        return this.lastModified;
    }

    public Task(TaskBuilder builder){
        taskId = builder.getTaskId();
        title = builder.getTitle();
        description = builder.getDescription();
        dueDate = builder.getDueDate();
        priorityLevel = builder.getPriorityLevel();
        statusEnum = builder.getStatusEnum();
        assignedUser = builder.getAssignedUser();
        reminder = builder.getReminder();
        creationDate = builder.getCreationDate();
        lastModified = builder.getLastModified();
    }

    public String getTitle() {
        return title;
    }

    public Long getTaskId(){
        return taskId;
    }

    public void setTitle(String title) {
        this.title = title;
        lastModified = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        lastModified = LocalDateTime.now();
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        lastModified = LocalDateTime.now();
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
        lastModified = LocalDateTime.now();
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
        lastModified = LocalDateTime.now();
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
        lastModified = LocalDateTime.now();
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
        lastModified = LocalDateTime.now();
    }

    public void remind(){
        reminder.sendNotification();
    }
}
