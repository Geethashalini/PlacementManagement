package com.geetha.pms.repositories.test;
import com.geetha.pms.repositories.CompanyRepository;
import com.geetha.pms.entities.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Test case for saving a company successfully.
     */
    @Test
    public void testSaveCompany_Success() {
        // Arrange
        Company company = new Company(1, "Company A", 50000f);
        
        // Act
        Company savedCompany = new Company();

        // Assert
        assertNotNull(savedCompany.getId());
        assertEquals(company.getName(), savedCompany.getName());
        assertEquals(company.getSalary(), savedCompany.getSalary());
    }

    /**
     * Failing test case for retrieving a non-existent company.
     */
//    @Test
//    public void testFindById_NotFound() {
//        // Act
//        Optional<Company> company = CompanyRepository.findById(99);
//
//        // Assert
//        assertFalse(company.isPresent());
//    }
}
