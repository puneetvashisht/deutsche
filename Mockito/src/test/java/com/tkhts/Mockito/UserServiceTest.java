package com.tkhts.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tkhts.Mockito.entity.User;
import com.tkhts.Mockito.repo.UserRepository;
import com.tkhts.Mockito.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() throws SQLException {
        User user = new User(1, "John Doe", "john.doe@example.com");
        when(userRepository.getUserById(1)).thenReturn(user);

        User result = userService.getUserById(1);
        assertEquals(user, result);
    }

    @Test
    public void testGetAllUsers() throws SQLException {
        User user1 = new User(1, "John Doe", "john.doe@example.com");
        User user2 = new User(2, "Jane Doe", "jane.doe@example.com");
        List<User> users = Arrays.asList(user1, user2);
        when(userRepository.getAllUsers()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(users, result);
    }

    @Test
    public void testSaveUser() throws SQLException {
        User user = new User(1, "John Doe", "john.doe@example.com");

        userService.saveUser(user);
        verify(userRepository, times(1)).saveUser(user);
    }
}
