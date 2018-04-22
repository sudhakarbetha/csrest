package com.opentext.csrest.controllers;

import com.opentext.csrest.models.User;
import com.opentext.csrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/user/{name}")
    public User getUser(
            @PathVariable("name") String name
    ){
        return userService.getUser(name);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public User addUser(
            @RequestBody User user
    )
    {
        return userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public User updateUser(
            @RequestBody User user
    ){
        return userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{name}")
    public void deleteUser(
            @PathVariable(value = "name",required = true) String name
    ){
        userService.deleteUser(name);
    }


}
