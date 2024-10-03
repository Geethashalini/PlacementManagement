package com.geetha.pms.repositories.test;

import com.geetha.pms.entities.Certificate;
import com.geetha.pms.repositories.CertificateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CertificateRepositoryTest {

    @Autowired
    private CertificateRepository certificateRepository;

    private Certificate certificate;

    @BeforeEach
    public void setUp() {
        certificate = new Certificate(1001, 2023, null); // Use null for College here since it's not the focus
        certificateRepository.save(certificate);
    }

    @Test
    public void testSaveCertificate() {
        Certificate savedCertificate = certificateRepository.save(new Certificate(1002, 2024, null));
        assertNotNull(savedCertificate);
        assertEquals(1002, savedCertificate.getId());
        assertEquals(2024, savedCertificate.getYear());
    }

    @Test
    public void testFindCertificateById() {
        Optional<Certificate> foundCertificate = certificateRepository.findById(certificate.getId());
        assertTrue(foundCertificate.isPresent());
        assertEquals(certificate.getId(), foundCertificate.get().getId());
    }

    @Test
    public void testUpdateCertificate() {
        Certificate foundCertificate = certificateRepository.findById(certificate.getId()).orElse(null);
        assertNotNull(foundCertificate);
        foundCertificate.setYear(2025);
        Certificate updatedCertificate = certificateRepository.save(foundCertificate);
        assertEquals(2025, updatedCertificate.getYear());
    }

    @Test
    public void testDeleteCertificate() {
        certificateRepository.deleteById(certificate.getId());
        Optional<Certificate> deletedCertificate = certificateRepository.findById(certificate.getId());
        assertFalse(deletedCertificate.isPresent());
    }

//    @Test
//    public void testFindAllCertificates() {
//        Certificate secondCertificate = new Certificate(1003, 2024, null);
//        certificateRepository.save(secondCertificate);
//        Iterable<Certificate> certificates = certificateRepository.findAll();
//        assertEquals(2, ((List<Certificate>) certificates).size(), "There should be two certificates in the database");
//    }

    // Failing test cases (commented out)

    // @Test
    // public void testFindNonExistentCertificate() {
    //     Optional<Certificate> nonExistentCertificate = certificateRepository.findById(9999);
    //     assertTrue(nonExistentCertificate.isPresent(), "The certificate should not exist");
    // }

    // @Test
    // public void testDeleteNonExistentCertificate() {
    //     certificateRepository.deleteById(9999);
    //     Optional<Certificate> deletedCertificate = certificateRepository.findById(9999);
    //     assertTrue(deletedCertificate.isPresent(), "There should be no certificate with this ID");
    // }
}

