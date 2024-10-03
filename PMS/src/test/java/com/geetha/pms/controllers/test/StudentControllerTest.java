package com.geetha.pms.controllers.test;



import com.geetha.pms.controllers.StudentController;
import com.geetha.pms.entities.Student;
import com.geetha.pms.services.StudentService;
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

public class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for retrieving all students successfully.
     */
    @Test
    public void testGetAllStudents_Success() {
        // Arrange
        Student student1 = new Student(1, "John Doe", null, "john@example.com", "Computer Science", 0, null);
        Student student2 = new Student(2, "Jane Doe", null, "jane@example.com", "Information Technology", 0, null);
        List<Student> students = Arrays.asList(student1, student2);
        when(studentService.listAll()).thenReturn(students);

        // Act
        ResponseEntity<List<Student>> response = studentController.getAllStudents();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(students, response.getBody());
    }

    /**
     * Test case for adding a student successfully.
     */
    @Test
    public void testAddStudent_Success() {
        // Arrange
        Student student = new Student(1, "John Doe", null, "john@example.com", "Computer Science", 0, null);
        
        // Act
        ResponseEntity<String> response = studentController.addStudent(student);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Student added successfully", response.getBody());
        verify(studentService).save(student);
    }

    /**
     * Failing test case for retrieving a student that does not exist.
     */
    @Test
    public void testGetStudent_NotFound() {
        // Arrange
        Integer id = 99;
        when(studentService.get(id)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<Student> response = studentController.getStudent(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
