package com.geetha.pms.repositories;



import com.geetha.pms.entities.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for College entity.
 */
@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {
}
