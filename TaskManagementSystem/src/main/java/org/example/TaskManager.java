package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private List<Task> taskList;
    private static volatile TaskManager INSTANCE;

    private UserManager userManager;

    private TaskManager(){
        taskList = new ArrayList<Task>();
    }

    public static synchronized TaskManager getInstance(){
        if(INSTANCE == null)
            INSTANCE = new TaskManager();
        return INSTANCE;
    }

    public void createTask(Task task){
        taskList.add(task);
    }

    public synchronized void updateTask(Task task){
        Optional<Task> taskContainer = taskList.stream().filter(t -> t.equals(task)).findFirst();
        taskContainer.ifPresent(t -> t.updateTask(task));
    }

    public void deleteTask(Long taskId){

        taskList.stream().filter(t->t.getTaskId().equals(taskId)).findFirst().ifPresent(t ->
        {t.getAssignedUser().removeTask(t);
            taskList.remove(t);});
    }

    public void assignTaskToUser(Task task, User user){
        if(task.getAssignedUser()!=null){
            task.getAssignedUser().removeTask(task);
        }
        user.assignTask(task);
    }
}
