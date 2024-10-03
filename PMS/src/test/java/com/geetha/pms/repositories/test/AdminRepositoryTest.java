package com.geetha.pms.repositories.test;


import static org.junit.jupiter.api.Assertions.*;

import com.geetha.pms.entities.Admin;
import com.geetha.pms.repositories.AdminRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@DataJpaTest
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    private Admin admin;

    @BeforeEach
    public void setUp() {
        admin = new Admin(1, "Admin Name", "AdminPassword");
        adminRepository.save(admin);
    }

    @Test
    public void testSaveAdmin() {
        Admin savedAdmin = adminRepository.save(new Admin(2, "New Admin", "NewPassword"));
        assertNotNull(savedAdmin);
        assertEquals(2, savedAdmin.getId());
    }

    @Test
    public void testFindById() {
        Optional<Admin> foundAdmin = adminRepository.findById(1);
        assertTrue(foundAdmin.isPresent(), "Admin should be found");
        assertEquals("Admin Name", foundAdmin.get().getName());
    }

    @Test
    public void testUpdateAdmin() {
        Optional<Admin> foundAdmin = adminRepository.findById(1);
        assertTrue(foundAdmin.isPresent());

        foundAdmin.get().setName("Updated Admin");
        Admin updatedAdmin = adminRepository.save(foundAdmin.get());
        
        assertEquals("Updated Admin", updatedAdmin.getName(), "Admin name should be updated");
    }

    @Test
    public void testDeleteAdmin() {
        adminRepository.deleteById(1);
        Optional<Admin> foundAdmin = adminRepository.findById(1);
        assertFalse(foundAdmin.isPresent(), "Admin should be deleted");
    }

    @Test
    public void testFindAllAdmins() {
    	Iterable<Admin> adminsIterable = adminRepository.findAll();
        
        // Convert Iterable to List
        List<Admin> admins = StreamSupport
                                .stream(adminsIterable.spliterator(), false)
                                .collect(Collectors.toList());

        assertNotNull(admins);
        assertEquals(1, admins.size(), "There should be one admin in the database");
    }

    // Two failing test cases for demonstration (in comments)

    /*
    @Test
    public void testFailingFindById() {
        // This will fail because there's no admin with ID 99
        Optional<Admin> foundAdmin = adminRepository.findById(99);
        assertTrue(foundAdmin.isPresent(), "This test should fail because admin with ID 99 doesn't exist");
    }

    @Test
    public void testFailingDeleteAdmin() {
        // This will fail because we are trying to delete a non-existent admin
        adminRepository.deleteById(99);
        Optional<Admin> foundAdmin = adminRepository.findById(99);
        assertTrue(foundAdmin.isPresent(), "This test should fail because admin with ID 99 doesn't exist");
    }
    */
}
