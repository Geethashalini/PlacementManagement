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
    void setUp() {
        certificate = new Certificate(1, 2024, null);
        certificateRepository.save(certificate);
    }

    @Test
    void testFindById() {
        Optional<Certificate> foundCertificate = certificateRepository.findById(certificate.getId());

        assertTrue(foundCertificate.isPresent());
        assertEquals(certificate.getYear(), foundCertificate.get().getYear());
    }

    @Test
    void testFindByNonExistingId() {
        Optional<Certificate> foundCertificate = certificateRepository.findById(999);

        assertFalse(foundCertificate.isPresent());
    }

    @Test
    void testSaveCertificate() {
        Certificate newCertificate = new Certificate(2, 2025, null);
        Certificate savedCertificate = certificateRepository.save(newCertificate);

        assertNotNull(savedCertificate);
        assertEquals(newCertificate.getYear(), savedCertificate.getYear());
    }

    @Test
    void testDeleteCertificate() {
        certificateRepository.delete(certificate);

        Optional<Certificate> foundCertificate = certificateRepository.findById(certificate.getId());

        assertFalse(foundCertificate.isPresent());
    }

    // Failing test case example
    // @Test
    // void testDeleteNonExistingCertificate() {
    //     Certificate nonExistingCertificate = new Certificate(999, 2025, null);
    //     Exception exception = assertThrows(EntityNotFoundException.class, () -> {
    //         certificateRepository.delete(nonExistingCertificate);
    //     });
    //     assertEquals("Certificate not found with ID: 999", exception.getMessage());
    // }
}
