package com.geetha.pms.services.test;


import com.geetha.pms.entities.Placement;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.PlacementRepository;
import com.geetha.pms.services.PlacementService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlacementServiceTest {

    @InjectMocks
    private PlacementService placementService;

    @Mock
    private PlacementRepository placementRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for retrieving a placement successfully.
     */
    @Test
    public void testGetPlacement_Success() {
        // Arrange
        Placement placement = new Placement(1, "Placement A", LocalDate.of(2024, 10, 1), "BE", 2024);
        when(placementRepository.findById(1)).thenReturn(Optional.of(placement));

        // Act
        Placement result = placementService.get(1);

        // Assert
        assertEquals(placement, result);
    }

    /**
     * Failing test case for retrieving a placement that does not exist.
     */
    @Test
    public void testGetPlacement_NotFound() {
        // Arrange
        when(placementRepository.findById(1)).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            placementService.get(1);
        });
        assertEquals("Placement not found with ID: 1", exception.getMessage());
    }

    /**
     * Test case for saving a placement successfully.
     */
    @Test
    public void testSavePlacement_Success() {
        // Arrange
        Placement placement = new Placement(1, "Placement A", LocalDate.of(2024, 10, 1), "BE", 2024);
        when(placementRepository.save(placement)).thenReturn(placement);

        // Act
        Placement result = placementService.save(placement);

        // Assert
        assertEquals(placement, result);
        verify(placementRepository).save(placement);
    }
}
