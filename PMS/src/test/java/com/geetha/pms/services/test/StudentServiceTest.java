package com.geetha.pms.services.test;


import com.geetha.pms.entities.Student;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.StudentRepository;
import com.geetha.pms.services.StudentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for retrieving a student successfully.
     */
    @Test
    public void testGetStudent_Success() {
        // Arrange
        Student student = new Student(1, "John Doe", null, "john@example.com", "Computer Science", 0, null);
        when(studentRepository.findById(1)).thenReturn(java.util.Optional.of(student));

        // Act
        Student result = studentService.get(1);

        // Assert
        assertEquals(student, result);
    }

    /**
     * Failing test case for retrieving a student that does not exist.
     */
    @Test
    public void testGetStudent_NotFound() {
        // Arrange
        when(studentRepository.findById(1)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            studentService.get(1);
        });
        assertEquals("Student not found with ID: 1", exception.getMessage());
    }

    /**
     * Test case for saving a student successfully.
     */
    @Test
    public void testSaveStudent_Success() {
        // Arrange
        Student student = new Student(1, "John Doe", null, "john@example.com", "Computer Science", 0, null);
        when(studentRepository.save(student)).thenReturn(student);

        // Act
        Student result = studentService.save(student);

        // Assert
        assertEquals(student, result);
        verify(studentRepository).save(student);
    }
}

