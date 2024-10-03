package com.geetha.pms.entities.test;

import com.geetha.pms.entities.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Admin entity class.
 */
public class AdminTest {

    private Admin admin;

    @BeforeEach
    public void setUp() {
        admin = new Admin(1, "AdminName", "AdminPass123");
    }

    /**
     * Test case to verify the getId method.
     */
    @Test
    public void testGetId() {
        assertEquals(1, admin.getId());
    }

    /**
     * Test case to verify the setId method.
     */
    @Test
    public void testSetId() {
        admin.setId(2);
        assertEquals(2, admin.getId());
    }

    /**
     * Test case to verify the getName method.
     */
    @Test
    public void testGetName() {
        assertEquals("AdminName", admin.getName());
    }

    /**
     * Test case to verify the setName method.
     */
    @Test
    public void testSetName() {
        admin.setName("NewAdminName");
        assertEquals("NewAdminName", admin.getName());
    }

    /**
     * Test case to verify the toString method.
     */
    @Test
    public void testToString() {
        String expectedString = "Admin [id=1, name=AdminName, password=AdminPass123]";
        assertEquals(expectedString, admin.toString());
    }

    // Failing test cases (these are commented out):
    // Uncomment and run to see the failure.

    /*
    // This test will fail because the name is not "WrongName".
    @Test
    public void testGetName_Failing() {
        assertEquals("WrongName", admin.getName());
    }

    // This test will fail because the ID is not 99.
    @Test
    public void testGetId_Failing() {
        assertEquals(99, admin.getId());
    }
    */
}
