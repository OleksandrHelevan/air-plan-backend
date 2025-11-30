package com.airplan.flightservice.core.persistance;

import com.airplan.flightservice.domains.flight.FlightSegment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlightSegmentRepository extends JpaRepository<FlightSegment, UUID> {
}