package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users;

    public UserManager(){
        users = new ArrayList<User>();
    }

    public void createUser(User user){
        users.add(user);
    }

    public void updateUser(User user){
        //Logic to find and update existing user
    }

    public void deleteUser(Long id){
        users.stream().filter(u -> u.getUserId().equals(id)).findFirst().ifPresent(u -> users.remove(u));
    }

    public List<User> getAllUsers(){
        return users;
    }

}
