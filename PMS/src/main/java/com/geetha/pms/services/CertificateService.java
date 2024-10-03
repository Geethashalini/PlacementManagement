package com.geetha.pms.services;


import com.geetha.pms.entities.Certificate;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.CertificateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service class for Certificate entity.
 */
@Service
@Transactional
public class CertificateService {

    @Autowired
    private CertificateRepository repo;

    public List<Certificate> listAll() {
        return repo.findAll();
    }

    public Certificate get(Integer id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Certificate not found with ID: " + id));
    }

    public Certificate save(Certificate certificate) {
        return repo.save(certificate);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Certificate not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}

