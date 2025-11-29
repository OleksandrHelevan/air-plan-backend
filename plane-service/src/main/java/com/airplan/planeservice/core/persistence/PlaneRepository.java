package com.airplan.planeservice.core.persistence;

import com.airplan.planeservice.domains.plane.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, UUID> {
}
