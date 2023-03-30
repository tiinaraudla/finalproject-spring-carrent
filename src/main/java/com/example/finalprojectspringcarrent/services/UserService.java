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
     * To create a new user
     *
     * @param user User
     */
    void createUser(User user);

    /**
     * To find a user by ID
     *
     * @param name User ID
     * @return User
     */
    User findUserByName(Long name) throws UserNotFoundException;

    /**
     * To find a user by name
     *
     * @param lastName Customer lastName
     * @return Customer
     */
    User findUserByLastName(String lastName) throws UserNotFoundException;

    /**
     * To find all customers
     *
     * @return a list of customer
     */
    List<User> findAllUser();

    /**
     * To update an existing User
     *
     * @param user User
     */
    void updateUser(User user) throws UserNotFoundException;

    /**
     * To delete a User by ID
     *
     * @param id User ID
     */
    void deleteUserById(Long id) throws UserNotFoundException;

    /**
     * To restore a User by ID
     *
     * @param id User ID
     */
    void restoreUserById(Long id) throws UserNotFoundException;
}
