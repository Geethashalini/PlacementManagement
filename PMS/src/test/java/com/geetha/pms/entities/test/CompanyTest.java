package com.geetha.pms.entities.test;

import com.geetha.pms.entities.Company;
import com.geetha.pms.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for Company entity.
 */
public class CompanyTest {

    private Company company;
    private Set<Student> placedStudents;

    @BeforeEach
    public void setUp() {
        // Initialize mock placed students
        placedStudents = new HashSet<>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Student 1");
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Student 2");

        placedStudents.add(student1);
        placedStudents.add(student2);

        // Initialize Company object
        company = new Company(1, "Test Company", 50000f);
        company.setPlacedStudents(placedStudents);
    }

    @Test
    public void testGetId() {
        assertEquals(1, company.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Company", company.getName());
    }

    @Test
    public void testGetSalary() {
        assertEquals(50000f, company.getSalary());
    }

    @Test
    public void testGetPlacedStudents() {
        assertNotNull(company.getPlacedStudents());
        assertEquals(2, company.getPlacedStudents().size());  // There should be 2 students placed
    }

    @Test
    public void testSetName() {
        company.setName("New Company Name");
        assertEquals("New Company Name", company.getName());
    }

    // Failing test cases (for demonstration purposes, commented out)
    
    // @Test
    // public void testFailingGetId() {
    //     // This test will fail because the expected ID is incorrect
    //     assertEquals(2, company.getId());  // Expected ID is incorrect
    // }

    // @Test
    // public void testFailingGetSalary() {
    //     // This test will fail because the expected salary is incorrect
    //     assertEquals(60000f, company.getSalary());  // Expected salary is incorrect
    // }
}
