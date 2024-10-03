package com.geetha.pms.controllers;

import com.geetha.pms.entities.College;
import com.geetha.pms.services.CollegeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for College operations.
 */
@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping
    public ResponseEntity<List<College>> getAllColleges() {
        List<College> colleges = collegeService.listAll();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCollege(@RequestBody College college) {
        collegeService.save(college);
        return new ResponseEntity<>("College added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollege(@PathVariable Integer id) {
        try {
            College college = collegeService.get(id);
            return new ResponseEntity<>(college, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCollege(@RequestBody College college, @PathVariable Integer id) {
        try {
            College existingCollege = collegeService.get(id);
            college.setId(id);
            collegeService.save(college);
            return new ResponseEntity<>("College updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCollege(@PathVariable Integer id) {
        try {
            collegeService.delete(id);
            return new ResponseEntity<>("College deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
