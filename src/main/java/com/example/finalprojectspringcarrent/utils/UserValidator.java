package com.example.finalprojectspringcarrent.utils;

import com.example.finalprojectspringcarrent.exceptions.UserValidationException;
import com.example.finalprojectspringcarrent.models.User;
import com.example.finalprojectspringcarrent.models.UserType;

/**
 * @author Tiina Raudla
 * @Date
 */
public class UserValidator {
    public boolean isOwnerUser(User user) throws UserValidationException {
        String fullName = user.getFirsName() + " " + user.getLastName();

        if(user.getUserType() == null) {
            throw new NullPointerException(String.format("The user type is null for user: %s", fullName));
        }
        if (UserType.OWNER.equals(user.getUserType())){
            return true;
        } else {
            throw new UserValidationException(fullName, "User owner check failed!");
        }
}
}

