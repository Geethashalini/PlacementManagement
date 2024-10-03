package com.geetha.pms.services;


import com.geetha.pms.entities.College;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.CollegeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service class for College entity.
 */
@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeRepository repo;

    public List<College> listAll() {
        return repo.findAll();
    }

    public College get(Integer id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("College not found with ID: " + id));
    }

    public College save(College college) {
        return repo.save(college);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("College not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}


