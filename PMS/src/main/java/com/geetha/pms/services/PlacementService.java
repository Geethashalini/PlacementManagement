package com.geetha.pms.services;


import com.geetha.pms.entities.Placement;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.PlacementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service class for Placement entity.
 */
@Service
@Transactional
public class PlacementService {

    @Autowired
    private PlacementRepository repo;

    public List<Placement> listAll() {
        return repo.findAll();
    }

    public Placement get(Integer id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Placement not found with ID: " + id));
    }

    public Placement save(Placement placement) {
        return repo.save(placement);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Placement not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}

