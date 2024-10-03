package com.geetha.pms.controllers.test;



import com.geetha.pms.controllers.CompanyController;
import com.geetha.pms.entities.Company;
import com.geetha.pms.services.CompanyService;
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

public class CompanyControllerTest {

    @InjectMocks
    private CompanyController companyController;

    @Mock
    private CompanyService companyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for retrieving all companies successfully.
     */
    @Test
    public void testGetAllCompanies_Success() {
        // Arrange
        Company company1 = new Company(1, "Company A", 50000f);
        Company company2 = new Company(2, "Company B", 60000f);
        List<Company> companies = Arrays.asList(company1, company2);
        when(companyService.listAll()).thenReturn(companies);

        // Act
        ResponseEntity<List<Company>> response = companyController.getAllCompanies();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(companies, response.getBody());
    }

    /**
     * Test case for adding a company successfully.
     */
    @Test
    public void testAddCompany_Success() {
        // Arrange
        Company company = new Company(1, "Company A", 50000f);
        
        // Act
        ResponseEntity<String> response = companyController.addCompany(company);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Company added successfully", response.getBody());
        verify(companyService).save(company);
    }

    /**
     * Failing test case for retrieving a company that does not exist.
     */
    @Test
    public void testGetCompany_NotFound() {
        // Arrange
        Integer id = 99;
        when(companyService.get(id)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<Company> response = companyController.getCompany(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
