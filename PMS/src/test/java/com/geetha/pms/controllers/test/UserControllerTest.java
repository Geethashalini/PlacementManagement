package com.geetha.pms.controllers.test;

import com.geetha.pms.controllers.UserController;
import com.geetha.pms.entities.User;
import com.geetha.pms.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for retrieving all users successfully.
     */
    @Test
    public void testGetAllUsers_Success() {
        // Arrange
        User user1 = new User(1L, "Admin", "admin", "password123");
        User user2 = new User(2L, "Student", "student", "password123");
        List<User> users = Arrays.asList(user1, user2);
        when(userService.listAll()).thenReturn(users);

        // Act
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    /**
     * Test case for adding a user successfully.
     */
    @Test
    public void testAddUser_Success() {
        // Arrange
        User user = new User(1L, "Admin", "admin", "password123");
        
        // Act
        ResponseEntity<String> response = userController.addUser(user);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("User added successfully", response.getBody());
        verify(userService).save(user);
    }

    /**
     * Failing test case for retrieving a user that does not exist.
     */
    @Test
    public void testGetUser_NotFound() {
        // Arrange
        Long id = 99L;
        when(userService.get(id)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<User> response = userController.getUser(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
