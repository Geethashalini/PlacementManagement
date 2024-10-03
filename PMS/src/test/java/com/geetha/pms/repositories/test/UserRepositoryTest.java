package com.geetha.pms.repositories.test;


import com.geetha.pms.entities.User;
import com.geetha.pms.repositories.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * Test case for saving a user successfully.
     */
    @Test
    public void testSaveUser_Success() {
        // Arrange
        User user = new User(1L, "Admin", "admin", "password123");
        
        // Act
        User savedUser = userRepository.save(user);

        // Assert
        assertNotNull(savedUser.getId());
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getType(), savedUser.getType());
        assertEquals(user.getPassword(), savedUser.getPassword());
    }

    /**
     * Failing test case for retrieving a non-existent user.
     */
    @Test
    public void testFindById_NotFound() {
        // Act
        Optional<User> user = userRepository.findById(99L);

        // Assert
        assertFalse(user.isPresent());
    }
}

