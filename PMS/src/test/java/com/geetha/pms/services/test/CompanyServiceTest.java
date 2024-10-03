package com.geetha.pms.services.test;


import com.geetha.pms.entities.Company;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.CompanyRepository;
import com.geetha.pms.services.CompanyService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for retrieving a company successfully.
     */
    @Test
    public void testGetCompany_Success() {
        // Arrange
        Company company = new Company(1, "Company A", 50000f);
        when(companyRepository.findById(1)).thenReturn(Optional.of(company));

        // Act
        Company result = companyService.get(1);

        // Assert
        assertEquals(company, result);
    }

    /**
     * Failing test case for retrieving a company that does not exist.
     */
    @Test
    public void testGetCompany_NotFound() {
        // Arrange
        when(companyRepository.findById(1)).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            companyService.get(1);
        });
        assertEquals("Company not found with ID: 1", exception.getMessage());
    }

    /**
     * Test case for saving a company successfully.
     */
    @Test
    public void testSaveCompany_Success() {
        // Arrange
        Company company = new Company(1, "Company A", 50000f);
        when(companyRepository.save(company)).thenReturn(company);

        // Act
        Company result = companyService.save(company);

        // Assert
        assertEquals(company, result);
        verify(companyRepository).save(company);
    }
}
