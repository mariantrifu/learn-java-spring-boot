package com.learnjavaspringboot.restapilearning.service;

import com.learnjavaspringboot.restapilearning.model.User;
import com.learnjavaspringboot.restapilearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}
