package com.geetha.pms.controllers;

import com.geetha.pms.entities.Placement;
import com.geetha.pms.services.PlacementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Placement operations.
 */
@RestController
@RequestMapping("/placements")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @GetMapping
    public ResponseEntity<List<Placement>> getAllPlacements() {
        List<Placement> placements = placementService.listAll();
        return new ResponseEntity<>(placements, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addPlacement(@RequestBody Placement placement) {
        placementService.save(placement);
        return new ResponseEntity<>("Placement added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Placement> getPlacement(@PathVariable Integer id) {
        try {
            Placement placement = placementService.get(id);
            return new ResponseEntity<>(placement, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlacement(@RequestBody Placement placement, @PathVariable Integer id) {
        try {
            Placement existingPlacement = placementService.get(id);
            placement.setId(id);
            placementService.save(placement);
            return new ResponseEntity<>("Placement updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlacement(@PathVariable Integer id) {
        try {
            placementService.delete(id);
            return new ResponseEntity<>("Placement deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

