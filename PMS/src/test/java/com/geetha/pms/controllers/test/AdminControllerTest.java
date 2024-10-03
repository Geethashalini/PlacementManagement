package com.geetha.pms.controllers.test;

import com.geetha.pms.controllers.AdminController;
import com.geetha.pms.services.AdminService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(AdminController.class) // Use @WebMvcTest to load only controller-related beans
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    @Test
    public void testGetAllAdmins() throws Exception {
        // Mocking service layer
        when(adminService.listAll()).thenReturn(List.of());

        // Perform GET request and validate response
        mockMvc.perform(get("/admins"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // Assuming no admins are returned
    }
}
