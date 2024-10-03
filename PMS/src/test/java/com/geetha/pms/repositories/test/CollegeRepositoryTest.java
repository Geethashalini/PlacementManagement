package com.geetha.pms.repositories.test;

import com.geetha.pms.entities.College;
import com.geetha.pms.repositories.CollegeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CollegeRepositoryTest {

    @Autowired
    private CollegeRepository collegeRepository;

    private College college;

    @BeforeEach
    void setUp() {
        // Setup a College instance for testing
        college = new College();
        college.setCollegeName("Test College");
        college.setLocation("Test Location");
        
        // Check if the College class has a method to set collegeAdminId
        // If it doesn't, you can remove or comment out the following line
        // college.setCollegeAdminId(1);  // Uncomment this line if applicable
    }

    @Test
    void testSaveCollege() {
        // Save the college and assert it is saved correctly
        College savedCollege = collegeRepository.save(college);
        assertNotNull(savedCollege);
        assertEquals(college.getCollegeName(), savedCollege.getCollegeName());
        assertEquals(college.getLocation(), savedCollege.getLocation());
    }

    @Test
    void testFindCollegeById() {
        // Save the college first
        College savedCollege = collegeRepository.save(college);

        // Retrieve by ID and assert
        College foundCollege = collegeRepository.findById(savedCollege.getId()).orElse(null);
        assertNotNull(foundCollege);
        assertEquals(college.getCollegeName(), foundCollege.getCollegeName());
        assertEquals(college.getLocation(), foundCollege.getLocation());
    }

//    @Test
//    void testFindByNonExistingId() {
//        // Try finding a non-existing college
//        College foundCollege = collegeRepository.findById((int) 999L).orElse(null);
//        assertNull(foundCollege);
//    }
}
