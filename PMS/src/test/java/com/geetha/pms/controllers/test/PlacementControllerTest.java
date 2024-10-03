package com.geetha.pms.controllers.test;


import com.geetha.pms.controllers.PlacementController;
import com.geetha.pms.entities.Placement;
import com.geetha.pms.services.PlacementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlacementControllerTest {

    @InjectMocks
    private PlacementController placementController;

    @Mock
    private PlacementService placementService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for retrieving all placements successfully.
     */
    @Test
    public void testGetAllPlacements_Success() {
        // Arrange
        Placement placement1 = new Placement(1, "Placement A", LocalDate.of(2024, 10, 1), "BE", 2024);
        Placement placement2 = new Placement(2, "Placement B", LocalDate.of(2024, 10, 2), "BE", 2024);
        List<Placement> placements = Arrays.asList(placement1, placement2);
        when(placementService.listAll()).thenReturn(placements);

        // Act
        ResponseEntity<List<Placement>> response = placementController.getAllPlacements();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(placements, response.getBody());
    }

    /**
     * Test case for adding a placement successfully.
     */
    @Test
    public void testAddPlacement_Success() {
        // Arrange
        Placement placement = new Placement(1, "Placement A", LocalDate.of(2024, 10, 1), "BE", 2024);
        
        // Act
        ResponseEntity<String> response = placementController.addPlacement(placement);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Placement added successfully", response.getBody());
        verify(placementService).save(placement);
    }

    /**
     * Failing test case for retrieving a placement that does not exist.
     */
    @Test
    public void testGetPlacement_NotFound() {
        // Arrange
        Integer id = 99;
        when(placementService.get(id)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<Placement> response = placementController.getPlacement(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
