package com.geetha.pms.repositories;

import com.geetha.pms.entities.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Placement entity.
 */
@Repository
public interface PlacementRepository extends JpaRepository<Placement, Integer> {
}