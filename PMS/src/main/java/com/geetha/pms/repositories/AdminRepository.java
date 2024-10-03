package com.geetha.pms.repositories;

import com.geetha.pms.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Admin entity.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}