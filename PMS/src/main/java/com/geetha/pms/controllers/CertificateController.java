package com.geetha.pms.controllers;

import com.geetha.pms.entities.Certificate;
import com.geetha.pms.services.CertificateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Certificate operations.
 */
@RestController
@RequestMapping("/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ResponseEntity<List<Certificate>> getAllCertificates() {
        List<Certificate> certificates = certificateService.listAll();
        return new ResponseEntity<>(certificates, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCertificate(@RequestBody Certificate certificate) {
        certificateService.save(certificate);
        return new ResponseEntity<>("Certificate added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificate(@PathVariable Integer id) {
        try {
            Certificate certificate = certificateService.get(id);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCertificate(@RequestBody Certificate certificate, @PathVariable Integer id) {
        try {
            Certificate existingCertificate = certificateService.get(id);
            certificate.setId(id);
            certificateService.save(certificate);
            return new ResponseEntity<>("Certificate updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCertificate(@PathVariable Integer id) {
        try {
            certificateService.delete(id);
            return new ResponseEntity<>("Certificate deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

