package com.opentext.csrest.services;

import com.opentext.csrest.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static List<User> users= new ArrayList<User>();

    public List<User> getUsers()
    {
        return users;
    }

    public User addUser(User user){
        users.add(user);
        return user;
    }

    public User getUser(String username){
        for (User user: users
             ) { if(user.getUsername().equals(username)) return user;

        }
        return new User();
    }


    public void deleteUser(String username)
    {
        users.removeIf(user -> user.getUsername().equals(username));
    }

    public User updateUser(User user){
//        users.forEach( user1 -> {
//                    if (user1.getUsername().equals(user.getUsername())) {
//                        users.remove(user1);
//                        users.add(user);
//                    }
//                }
//            );
        users = users.stream()
                 .filter(user1 -> !user1.getUsername().equals(user.getUsername()))
                 .collect(Collectors.toList());

        users.add(user);

        return user;
    }
}
