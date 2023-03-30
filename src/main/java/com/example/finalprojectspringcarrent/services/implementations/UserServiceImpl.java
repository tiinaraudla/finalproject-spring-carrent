package com.example.finalprojectspringcarrent.services.implementations;

import com.example.finalprojectspringcarrent.exceptions.UserNotFoundException;
import com.example.finalprojectspringcarrent.models.User;
import com.example.finalprojectspringcarrent.repositories.UserRepository;
import com.example.finalprojectspringcarrent.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Tiina Raudla
 * @Date
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void createUser(User user) {
        /** user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); */
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public User findUserByName(Long username) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(String.valueOf(username));
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException(username);
        }
        return optionalUser.get();
    }

    @Override
    public User findUserByLastName(String lastName) throws UserNotFoundException {
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) throws UserNotFoundException {

    }

    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {

    }

    @Override
    public void restoreUserById(Long id) throws UserNotFoundException {

    }
}
