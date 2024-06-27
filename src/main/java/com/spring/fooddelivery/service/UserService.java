package com.spring.fooddelivery.service;

import com.spring.fooddelivery.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    boolean isEmailTaken(String email);

    boolean isUsernameTaken(String username);

    List<User> findAllUsers();

    User findByIdWithCalculations(int id);

}
