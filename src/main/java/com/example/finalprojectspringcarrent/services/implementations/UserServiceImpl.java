package com.example.finalprojectspringcarrent.services.implementations;

import com.example.finalprojectspringcarrent.exceptions.UserNotFoundException;
import com.example.finalprojectspringcarrent.models.User;
import com.example.finalprojectspringcarrent.repositories.UserRepository;
import com.example.finalprojectspringcarrent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
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

     @Autowired
     private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException(username);
        }

        return optionalUser.get();
    }

    @Override
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);
    }
}
