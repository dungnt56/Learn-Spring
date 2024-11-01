package com.test.unittest.service.impl;

import com.test.unittest.entity.User;
import com.test.unittest.repository.UserRepository;
import com.test.unittest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepository.save(user);
    }
}
