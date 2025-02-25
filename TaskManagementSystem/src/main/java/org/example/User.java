package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long userId;
    private String name;
    private String email;
    private List<Task> taskList;

    public User(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.taskList = new ArrayList<Task>();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void assignTask(Task task){
        taskList.add(task);
        task.setAssignedUser(this);
    }

    public void removeTask(Task task){
        task.setAssignedUser(null);
        taskList.remove(task);
    }

    public void assignTaskToUser(User user, Task task){
        //we can use userManager to check if user already exist or not and assign task based on it.
        user.assignTask(task);
        taskList.remove(task);
    }
}
