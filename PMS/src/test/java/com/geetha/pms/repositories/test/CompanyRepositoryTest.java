package com.geetha.pms.repositories.test;

import com.geetha.pms.entities.Company;
import com.geetha.pms.entities.Student;
import com.geetha.pms.repositories.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    private Company company;

    @BeforeEach
    public void setUp() {
        // Create a mock company entity
        company = new Company(101, "TechCorp", 85000.00f);
        companyRepository.save(company);
    }

    @Test
    public void testSaveCompany() {
        Company newCompany = new Company(102, "HealthTech", 90000.00f);
        Company savedCompany = companyRepository.save(newCompany);

        assertNotNull(savedCompany);
        assertEquals(102, savedCompany.getId());
        assertEquals("HealthTech", savedCompany.getName());
        assertEquals(90000.00f, savedCompany.getSalary());
    }

    @Test
    public void testFindCompanyById() {
        Optional<Company> foundCompany = companyRepository.findById(company.getId());
        assertTrue(foundCompany.isPresent());
        assertEquals(company.getId(), foundCompany.get().getId());
        assertEquals("TechCorp", foundCompany.get().getName());
    }

    @Test
    public void testUpdateCompany() {
        Company foundCompany = companyRepository.findById(company.getId()).orElse(null);
        assertNotNull(foundCompany);

        foundCompany.setSalary(95000.00f);
        Company updatedCompany = companyRepository.save(foundCompany);

        assertEquals(95000.00f, updatedCompany.getSalary());
    }

    @Test
    public void testDeleteCompany() {
        companyRepository.deleteById(company.getId());
        Optional<Company> deletedCompany = companyRepository.findById(company.getId());
        assertFalse(deletedCompany.isPresent());
    }

    @Test
    public void testPlacedStudents() {
        
     // Use default constructor and setters for Student
        Student student1 = new Student();
        student1.setId(201);
        student1.setName("Alice");
        student1.setRoll((long) 12334);
        student1.setCourse("Computer Science");
        student1.setYear(2023);

        Student student2 = new Student();
        student2.setId(202);
        student2.setName("Bob");
        student2.setRoll((long) 789);
        student2.setCourse("Information Technology");
        student2.setYear(2023);
        Set<Student> placedStudents = new HashSet<>();
        placedStudents.add(student1);
        placedStudents.add(student2);

        company.setPlacedStudents(placedStudents);
        Company updatedCompany = companyRepository.save(company);

        assertEquals(2, updatedCompany.getPlacedStudents().size(), "There should be two placed students");
    }

    // Failing test cases (commented out)

    // @Test
    // public void testFindNonExistentCompany() {
    //     Optional<Company> nonExistentCompany = companyRepository.findById(9999);
    //     assertTrue(nonExistentCompany.isPresent(), "The company should not exist");
    // }

    // @Test
    // public void testDeleteNonExistentCompany() {
    //     companyRepository.deleteById(9999);
    //     Optional<Company> deletedCompany = companyRepository.findById(9999);
    //     assertTrue(deletedCompany.isPresent(), "There should be no company with this ID");
    // }
}
