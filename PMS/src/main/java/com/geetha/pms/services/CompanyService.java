package com.geetha.pms.services;


import com.geetha.pms.entities.Company;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service class for Company entity.
 */
@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository repo;

    public List<Company> listAll() {
        return repo.findAll();
    }

    public Company get(Integer id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + id));
    }

    public Company save(Company company) {
        return repo.save(company);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Company not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}

