package com.geetha.pms.entities.test;

import static org.junit.jupiter.api.Assertions.*;

import com.geetha.pms.entities.College;
import com.geetha.pms.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    private User user;
    private List<College> colleges;

    @BeforeEach
    public void setUp() {
        // Creating dummy College objects and assigning to user
        colleges = new ArrayList<>();
        colleges.add(new College(101, "ABC College", "Location1", null));
        colleges.add(new College(102, "XYZ College", "Location2", null));

        user = new User(1L, "Admin User", "admin", "password123");
        user.setColleges(colleges);
    }

    @Test
    public void testUserName() {
        assertEquals("Admin User", user.getName(), "User name should be Admin User");
    }

    @Test
    public void testUserType() {
        assertEquals("admin", user.getType(), "User type should be admin");
    }

    @Test
    public void testUserPassword() {
        assertEquals("password123", user.getPassword(), "User password should be password123");
    }

    @Test
    public void testUserColleges() {
        assertNotNull(user.getColleges(), "User colleges list should not be null");
        assertEquals(2, user.getColleges().size(), "User should be associated with 2 colleges");
    }

    @Test
    public void testFirstCollegeName() {
        assertEquals("ABC College", user.getColleges().get(0).getCollegeName(), "First college name should be ABC College");
    }

    // Two failing test cases for demonstration (in comments)

    /*
    @Test
    public void testFailingUserName() {
        // This will fail because the name is "Admin User", not "User Admin"
        assertEquals("User Admin", user.getName(), "This test should fail");
    }

    @Test
    public void testFailingUserPassword() {
        // This will fail because the password is "password123", not "wrongpassword"
        assertEquals("wrongpassword", user.getPassword(), "This test should fail");
    }
    */
}
