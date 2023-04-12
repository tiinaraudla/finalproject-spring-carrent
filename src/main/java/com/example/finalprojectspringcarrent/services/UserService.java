package com.example.finalprojectspringcarrent.services;

import com.example.finalprojectspringcarrent.exceptions.UserNotFoundException;
import com.example.finalprojectspringcarrent.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */
public interface UserService {
    /**
     * To find all users
     *
     * @return a list of User
     */
    List<User> findAllUsers();

    /**
     * To find user by Username
     *
     * @param username username
     * @return User
     */
    User findUserByUsername(String username) throws UserNotFoundException;

    /**
     * To create a new User
     *
     * @param user User
     */
    void createUser(User user);
}
