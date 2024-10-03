
package com.geetha.pms.services.test;

import com.geetha.pms.entities.Certificate;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.CertificateRepository;
import com.geetha.pms.services.CertificateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CertificateServiceTest {

    @InjectMocks
    private CertificateService certificateService;

    @Mock
    private CertificateRepository certificateRepository;

    private Certificate certificate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        certificate = new Certificate(1, 2024, null);
    }

    @Test
    void testListAllCertificates() {
        when(certificateRepository.findAll()).thenReturn(List.of(certificate));

        List<Certificate> certificates = certificateService.listAll();

        assertEquals(1, certificates.size());
        assertEquals(certificate, certificates.get(0));
    }

    @Test
    void testGetCertificate() {
        when(certificateRepository.findById(certificate.getId())).thenReturn(Optional.of(certificate));

        Certificate foundCertificate = certificateService.get(certificate.getId());

        assertEquals(certificate, foundCertificate);
    }

    @Test
    void testSaveCertificate() {
        when(certificateRepository.save(certificate)).thenReturn(certificate);

        Certificate savedCertificate = certificateService.save(certificate);

        assertEquals(certificate, savedCertificate);
    }

    @Test
    void testDeleteCertificate() {
        when(certificateRepository.existsById(certificate.getId())).thenReturn(true);

        certificateService.delete(certificate.getId());

        verify(certificateRepository, times(1)).deleteById(certificate.getId());
    }

    @Test
    void testDeleteNonExistingCertificate() {
        when(certificateRepository.existsById(certificate.getId())).thenReturn(false);

        // Expect EntityNotFoundException
        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            certificateService.delete(certificate.getId());
        });

        assertEquals("Certificate not found with ID: 1", exception.getMessage());
    }

    // Failing test case example
    // @Test
    // void testGetNonExistingCertificate() {
    //     when(certificateRepository.findById(anyInt())).thenReturn(Optional.empty());

    //     Exception exception = assertThrows(EntityNotFoundException.class, () -> {
    //         certificateService.get(999);
    //     });

    //     assertEquals("Certificate not found with ID: 999", exception.getMessage());
    // }
}
