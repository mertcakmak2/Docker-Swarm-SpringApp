package com.example.dockerizeapp.Service.User;

import com.example.dockerizeapp.Model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User findUserById(String id);
    List<User> findAll();

}
