package com.tkhts.Mockito.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkhts.Mockito.entity.User;
import com.tkhts.Mockito.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }
}

