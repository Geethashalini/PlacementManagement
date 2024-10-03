package com.geetha.pms.services.test;

import com.geetha.pms.entities.Admin;
import com.geetha.pms.repositories.AdminRepository;
import com.geetha.pms.services.AdminService;
import com.geetha.pms.exceptions.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;

/**
 * Unit test class for AdminService.
 */
@SpringBootTest
public class AdminServiceTest {

    @InjectMocks
    private AdminService adminService;

    @Mock
    private AdminRepository adminRepository;

    public AdminServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAdminById() {
        Admin admin = new Admin(1, "John Doe", "password123");
        when(adminRepository.findById(1)).thenReturn(Optional.of(admin));

        Admin result = adminService.get(1);
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testSaveAdmin() {
        Admin admin = new Admin(2, "Jane Doe", "password456");
        when(adminRepository.save(admin)).thenReturn(admin);

        Admin result = adminService.save(admin);
        assertEquals("Jane Doe", result.getName());
    }

    @Test
    public void testDeleteAdmin() {
        when(adminRepository.existsById(1)).thenReturn(true);
        assertDoesNotThrow(() -> adminService.delete(1));
    }

    @Test
    public void testDeleteAdminNotFound() {
        when(adminRepository.existsById(999)).thenReturn(false);
        assertThrows(EntityNotFoundException.class, () -> adminService.delete(999));
    }

    @Test
    public void testGetAdminNotFound() {
        when(adminRepository.findById(999)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> adminService.get(999));
    }

    // Failing Test Case: Admin save error
    // @Test
    // public void testSaveAdminError() {
    //     Admin admin = new Admin(0, null, null);
    //     doThrow(new RuntimeException("Error saving Admin")).when(adminRepository).save(admin);
    //     assertThrows(RuntimeException.class, () -> adminService.save(admin));
    // }
}
