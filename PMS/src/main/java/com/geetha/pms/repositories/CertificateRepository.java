package com.geetha.pms.repositories;

import com.geetha.pms.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Certificate entity.
 */
@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
}