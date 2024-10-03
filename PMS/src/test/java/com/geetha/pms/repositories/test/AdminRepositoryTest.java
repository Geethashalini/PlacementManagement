package com.geetha.pms.repositories.test;

import com.geetha.pms.entities.Admin;
import com.geetha.pms.repositories.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for AdminRepository.
 */
@DataJpaTest
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testSaveAdmin() {
        Admin admin = new Admin(1, "John Doe", "password123");
        Admin savedAdmin = adminRepository.save(admin);
        assertNotNull(savedAdmin);
        assertEquals("John Doe", savedAdmin.getName());
    }

    @Test
    public void testFindById() {
        Admin admin = new Admin(1, "John Doe", "password123");
        adminRepository.save(admin);

        Optional<Admin> foundAdmin = adminRepository.findById(1);
        assertTrue(foundAdmin.isPresent());
        assertEquals("John Doe", foundAdmin.get().getName());
    }

    @Test
    public void testDeleteAdmin() {
        Admin admin = new Admin(1, "John Doe", "password123");
        adminRepository.save(admin);
        adminRepository.deleteById(1);

        Optional<Admin> deletedAdmin = adminRepository.findById(1);
        assertFalse(deletedAdmin.isPresent());
    }

    @Test
    public void testFindAllAdmins() {
        adminRepository.save(new Admin(1, "John Doe", "password123"));
        adminRepository.save(new Admin(2, "Jane Doe", "password456"));

        Iterable<Admin> admins = adminRepository.findAll();
        assertEquals(2, ((List<Admin>) admins).size());
    }

    @Test
    public void testAdminNotFound() {
        Optional<Admin> admin = adminRepository.findById(999);
        assertFalse(admin.isPresent());
    }

    // Failing Test Case: Error during delete
    // @Test
    // public void testDeleteAdminError() {
    //     assertThrows(RuntimeException.class, () -> adminRepository.deleteById(999));
    // }

    // Failing Test Case: Save invalid admin
    // @Test
    // public void testSaveInvalidAdmin() {
    //     Admin invalidAdmin = new Admin(null, null, null);
    //     assertThrows(Exception.class, () -> adminRepository.save(invalidAdmin));
    // }
}
