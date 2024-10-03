package com.geetha.pms.services;

import com.geetha.pms.entities.College;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.CollegeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service class for managing College entities.
 * 
 * This class provides business logic for handling College operations,
 * including retrieving, saving, and deleting colleges.
 */
@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeRepository repo;

    /**
     * Retrieves a list of all colleges.
     *
     * @return a list of College entities
     */
    public List<College> listAll() {
        return repo.findAll();
    }

    /**
     * Retrieves a college by its ID.
     *
     * @param id the ID of the college to be retrieved
     * @return the College entity with the specified ID
     * @throws EntityNotFoundException if the college is not found
     */
    public College get(Integer id) {
        return repo.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("College not found with ID: " + id));
    }

    /**
     * Saves a college entity to the database.
     *
     * @param college the College entity to be saved
     * @return the saved College entity
     */
    public College save(College college) {
        return repo.save(college);
    }

    /**
     * Deletes a college by its ID.
     *
     * @param id the ID of the college to be deleted
     * @throws EntityNotFoundException if the college is not found
     */
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("College not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}
