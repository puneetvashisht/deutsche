package com.tkhts.Mockito.repo;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tkhts.Mockito.entity.User;

@Repository
public class UserRepository {
    public User getUserById(int id) {
        // Simulate database access
        return new User(id, "John Doe", "john.doe@example.com");
    }

    public List<User> getAllUsers() {
        // Simulate database access
        return Arrays.asList(
            new User(1, "John Doe", "john.doe@example.com"),
            new User(2, "Jane Doe", "jane.doe@example.com")
        );
    }

    public void saveUser(User user) {
        // Simulate database access
        System.out.println("User saved: " + user);
    }
}
