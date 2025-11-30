package com.airplan.flightservice.core.persistance;

import com.airplan.flightservice.domains.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
}