package com.geetha.pms.services;


import com.geetha.pms.entities.Admin;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service class for Admin entity.
 */
@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public List<Admin> listAll() {
        return repo.findAll();
    }

    public Admin get(Integer id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Admin not found with ID: " + id));
    }

    public Admin save(Admin admin) {
        return repo.save(admin);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Admin not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}

