
package com.geetha.pms.controllers.test;

import com.geetha.pms.controllers.CertificateController;
import com.geetha.pms.entities.Certificate;
import com.geetha.pms.services.CertificateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CertificateControllerTest {

    @InjectMocks
    private CertificateController certificateController;

    @Mock
    private CertificateService certificateService;

    private Certificate certificate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        certificate = new Certificate(1, 2024, null); // assuming college is not null in tests
    }

    @Test
    void testGetAllCertificates() {
        // Setup mock response
        List<Certificate> certificates = new ArrayList<>();
        certificates.add(certificate);
        when(certificateService.listAll()).thenReturn(certificates);

        // Call the method
        ResponseEntity<List<Certificate>> response = certificateController.getAllCertificates();

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testAddCertificate() {
        // Call the method
        ResponseEntity<String> response = certificateController.addCertificate(certificate);

        // Assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Certificate added successfully", response.getBody());
        verify(certificateService, times(1)).save(certificate);
    }

    @Test
    void testGetCertificate() {
        when(certificateService.get(certificate.getId())).thenReturn(certificate);

        ResponseEntity<Certificate> response = certificateController.getCertificate(certificate.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(certificate, response.getBody());
    }

    @Test
    void testUpdateCertificate() {
        when(certificateService.get(certificate.getId())).thenReturn(certificate);

        ResponseEntity<String> response = certificateController.updateCertificate(certificate, certificate.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Certificate updated successfully", response.getBody());
        verify(certificateService, times(1)).save(certificate);
    }

//    @Test
//    void testDeleteCertificate() {
//        doNothing().when(certificateService).delete(certificate.getId());
//
//        ResponseEntity<String> response = CertificateController.deleteCertificate(certificate.getId());
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Certificate deleted successfully", response.getBody());
//        verify(certificateService, times(1)).delete(certificate.getId());
//    }

    // Failing test case example
    // @Test
    // void testGetCertificateNotFound() {
    //     when(certificateService.get(anyInt())).thenThrow(new EntityNotFoundException("Certificate not found"));

    //     ResponseEntity<Certificate> response = certificateController.getCertificate(999);

    //     assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    // }
}
