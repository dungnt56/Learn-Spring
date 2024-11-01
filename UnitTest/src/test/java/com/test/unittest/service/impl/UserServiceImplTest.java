package com.test.unittest.service.impl;

import com.test.unittest.entity.User;
import com.test.unittest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser_Success() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userServiceImpl.createUser(user);

        verify(userRepository).save(user);
    }

    @Test
    void testCreateUser_EmailAlreadyExists() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.createUser(user));
    }
}
