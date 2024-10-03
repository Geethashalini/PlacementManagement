package com.geetha.pms.services.test;


import com.geetha.pms.entities.User;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.UserRepository;
import com.geetha.pms.services.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for retrieving a user successfully.
     */
    @Test
    public void testGetUser_Success() {
        // Arrange
        User user = new User(1L, "Admin", "admin", "password123");
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        // Act
        User result = userService.get(1L);

        // Assert
        assertEquals(user, result);
    }

    /**
     * Failing test case for retrieving a user that does not exist.
     */
    @Test
    public void testGetUser_NotFound() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            userService.get(1L);
        });
        assertEquals("User not found with ID: 1", exception.getMessage());
    }

    /**
     * Test case for saving a user successfully.
     */
    @Test
    public void testSaveUser_Success() {
        // Arrange
        User user = new User(1L, "Admin", "admin", "password123");
        when(userRepository.save(user)).thenReturn(user);

        // Act
        User result = userService.save(user);

        // Assert
        assertEquals(user, result);
        verify(userRepository).save(user);
    }
}
