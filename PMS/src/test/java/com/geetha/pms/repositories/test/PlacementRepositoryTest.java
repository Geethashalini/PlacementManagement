package com.geetha.pms.repositories.test;


import com.geetha.pms.entities.Placement;
import com.geetha.pms.repositories.PlacementRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PlacementRepositoryTest {

    @Autowired
    private PlacementRepository placementRepository;

    /**
     * Test case for saving a placement successfully.
     */
    @Test
    public void testSavePlacement_Success() {
        // Arrange
        Placement placement = new Placement(1, "Placement A", LocalDate.of(2024, 10, 1), "BE", 2024);
        
        // Act
        Placement savedPlacement = placementRepository.save(placement);

        // Assert
        assertNotNull(savedPlacement.getId());
        assertEquals(placement.getName(), savedPlacement.getName());
        assertEquals(placement.getDate(), savedPlacement.getDate());
        assertEquals(placement.getQualification(), savedPlacement.getQualification());
        assertEquals(placement.getYear(), savedPlacement.getYear());
    }

    /**
     * Failing test case for retrieving a non-existent placement.
     */
    @Test
    public void testFindById_NotFound() {
        // Act
        Optional<Placement> placement = placementRepository.findById(99);

        // Assert
        assertFalse(placement.isPresent());
    }
}
