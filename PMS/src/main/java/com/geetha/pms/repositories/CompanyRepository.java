package com.geetha.pms.repositories;

import com.geetha.pms.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Company entity.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}