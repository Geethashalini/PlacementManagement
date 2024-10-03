package com.geetha.pms.entities.test;

import com.geetha.pms.entities.Certificate;
import com.geetha.pms.entities.College;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Certificate entity class.
 */
public class CertificateTest {

    private Certificate certificate;
    private College college;

    @BeforeEach
    public void setUp() {
        // Mock College object (for simplicity, using a basic object)
    	college = new College();
    	college.setId(1);
    	college.setCollegeName("Test College");
    	college.setLocation("Test Location");

        // Initializing Certificate object
        certificate = new Certificate(101, 2023, college);
    }

    /**
     * Test case to verify the getId method.
     */
    @Test
    public void testGetId() {
        assertEquals(101, certificate.getId());
    }

    /**
     * Test case to verify the setId method.
     */
    @Test
    public void testSetId() {
        certificate.setId(102);
        assertEquals(102, certificate.getId());
    }

    /**
     * Test case to verify the getYear method.
     */
    @Test
    public void testGetYear() {
        assertEquals(2023, certificate.getYear());
    }

    /**
     * Test case to verify the setYear method.
     */
    @Test
    public void testSetYear() {
        certificate.setYear(2022);
        assertEquals(2022, certificate.getYear());
    }

    /**
     * Test case to verify the getCollege method.
     */
    @Test
    public void testGetCollege() {
        assertEquals(college, certificate.getCollege());
    }

    // Failing test cases (these are commented out):
    // Uncomment and run to see the failure.

    /*
    // This test will fail because the year is not 2021.
    @Test
    public void testGetYear_Failing() {
        assertEquals(2021, certificate.getYear());
    }

    // This test will fail because the college name is not "Wrong College".
    @Test
    public void testGetCollege_Failing() {
        assertEquals("Wrong College", certificate.getCollege().getCollegeName());
    }
    */
}
