package com.example.finalprojectspringcarrent.exceptions;

/**
 * @author Tiina Raudla
 * @Date
 */
public class UserNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(Long id) {
        super(String.format("User not found for id: %d", id));
    }
    public UserNotFoundException (String name) {
        super(String.format("User not found for lastName: %s", name));
    }
}
