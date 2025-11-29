package com.airplan.planeservice.core.persistence;

import com.airplan.planeservice.domains.airline.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, UUID> {
}
