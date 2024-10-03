package com.geetha.pms.repositories.test;

import com.geetha.pms.entities.College;
import com.geetha.pms.entities.User;
import com.geetha.pms.repositories.CollegeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CollegeRepositoryTest {

    @Autowired
    private CollegeRepository collegeRepository;

    private College college;
    private User collegeAdmin;

    @BeforeEach
    public void setUp() {
        // Creating a mock admin user
        collegeAdmin = new User(1L, "AdminName", "Admin", "adminpassword");

        // Creating a mock college entity
        college = new College(1001, "Engineering College", "New York", collegeAdmin);
        collegeRepository.save(college);
    }

    @Test
    public void testSaveCollege() {
        College newCollege = new College(1002, "Medical College", "Boston", collegeAdmin);
        College savedCollege = collegeRepository.save(newCollege);

        assertNotNull(savedCollege);
        assertEquals(1002, savedCollege.getId());
        assertEquals("Medical College", savedCollege.getCollegeName());
        assertEquals("Boston", savedCollege.getLocation());
    }

    @Test
    public void testFindCollegeById() {
        Optional<College> foundCollege = collegeRepository.findById(college.getId());
        assertTrue(foundCollege.isPresent());
        assertEquals(college.getId(), foundCollege.get().getId());
        assertEquals("Engineering College", foundCollege.get().getCollegeName());
    }

    @Test
    public void testUpdateCollege() {
        College foundCollege = collegeRepository.findById(college.getId()).orElse(null);
        assertNotNull(foundCollege);

        foundCollege.setLocation("San Francisco");
        College updatedCollege = collegeRepository.save(foundCollege);

        assertEquals("San Francisco", updatedCollege.getLocation());
    }

    @Test
    public void testDeleteCollege() {
        collegeRepository.deleteById(college.getId());
        Optional<College> deletedCollege = collegeRepository.findById(college.getId());
        assertFalse(deletedCollege.isPresent());
    }

    @Test
    public void testFindAllColleges() {
        College secondCollege = new College(1003, "Arts College", "Chicago", collegeAdmin);
        collegeRepository.save(secondCollege);

        List<College> colleges = collegeRepository.findAll();
        assertEquals(2, colleges.size(), "There should be two colleges in the database");
    }

    // Failing test cases (commented out)

    // @Test
    // public void testFindNonExistentCollege() {
    //     Optional<College> nonExistentCollege = collegeRepository.findById(9999);
    //     assertTrue(nonExistentCollege.isPresent(), "The college should not exist");
    // }

    // @Test
    // public void testDeleteNonExistentCollege() {
    //     collegeRepository.deleteById(9999);
    //     Optional<College> deletedCollege = collegeRepository.findById(9999);
    //     assertTrue(deletedCollege.isPresent(), "There should be no college with this ID");
    // }
}
