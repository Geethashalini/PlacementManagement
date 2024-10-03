package com.geetha.pms.repositories.test;


import com.geetha.pms.entities.Student;
import com.geetha.pms.repositories.StudentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Test case for saving a student successfully.
     */
    @Test
    public void testSaveStudent_Success() {
        // Arrange
        Student student = new Student(1, "John Doe", null, "john@example.com", "Computer Science", 0, null);
        
        // Act
        Student savedStudent = studentRepository.save(student);

        // Assert
        assertNotNull(savedStudent.getId());
        assertEquals(student.getName(), savedStudent.getName());
        assertEquals(student.getRoll(), savedStudent.getRoll());
        //assertEquals(student.getDepartment(), savedStudent.getDepartment());
    }

    /**
     * Failing test case for retrieving a non-existent student.
     */
    @Test
    public void testFindById_NotFound() {
        // Act
        Optional<Student> student = studentRepository.findById(99);

        // Assert
        assertFalse(student.isPresent());
    }
}
