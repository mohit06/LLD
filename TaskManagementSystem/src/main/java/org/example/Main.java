package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1L,"user1","user1@gmail.com");
        User user2 = new User(2L,"user2","user2@gmail.com");
        User user3 = new User(3L,"user3","user3@gmail.com");

        Task t1 = new TaskBuilder(1L,"TASK 1","This is my description", LocalDate.now().plusDays(14L),PriorityLevel.LOW).build();
        Task t2 = new TaskBuilder(2L,"TASK 2","This is my description", LocalDate.now().plusDays(14L),PriorityLevel.MEDIUM).build();
        Task t3 = new TaskBuilder(3L,"TASK 3","This is my description", LocalDate.now().plusDays(14L),PriorityLevel.HIGH).build();

        TaskManager tm = TaskManager.getInstance();
        UserManager um = new UserManager();
        um.createUser(user1);
        um.createUser(user2);
        um.createUser(user3);

        tm.createTask(t1);
        tm.createTask(t2);
        tm.createTask(t3);

        tm.assignTaskToUser(t1,user1);
        tm.assignTaskToUser(t2,user2);
        tm.assignTaskToUser(t3,user3);

        user1.assignTaskToUser(user2,t1);

        tm.deleteTask(2L);
    }
}
