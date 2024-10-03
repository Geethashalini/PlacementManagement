package com.geetha.pms.entities.test;

import com.geetha.pms.entities.College;
import com.geetha.pms.entities.Placement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for Placement entity.
 */
public class PlacementTest {

    private Placement placement;
    private College college;

    @BeforeEach
    public void setUp() {
        // Mock College object for testing purposes
        college = new College(1, "Test College", "Test Location", null);

        // Initialize Placement object
        placement = new Placement(101, "Test Placement", LocalDate.of(2024, 10, 1), "B.Tech", 2024);
        placement.setCollege(college);
    }

    @Test
    public void testGetId() {
        assertEquals(101, placement.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Placement", placement.getName());
    }

    @Test
    public void testGetDate() {
        assertEquals(LocalDate.of(2024, 10, 1), placement.getDate());
    }

    @Test
    public void testGetQualification() {
        assertEquals("B.Tech", placement.getQualification());
    }

    @Test
    public void testGetYear() {
        assertEquals(2024, placement.getYear());
    }

    @Test
    public void testGetCollege() {
        assertEquals(college, placement.getCollege());
    }

    // Failing test cases (for demonstration purposes, commented out)

    // @Test
    // public void testFailingGetId() {
    //     // This test will fail because the expected ID is incorrect
    //     assertEquals(999, placement.getId());  // Expected ID is incorrect
    // }

    // @Test
    // public void testFailingGetYear() {
    //     // This test will fail because the expected year is incorrect
    //     assertEquals(2025, placement.getYear());  // Expected year is incorrect
    // }
}

