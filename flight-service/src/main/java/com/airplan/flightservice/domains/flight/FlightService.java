package com.airplan.flightservice.domains.flight;

import com.airplan.flightservice.application.CreateFlightRequest;
import com.airplan.flightservice.application.FlightResponse;

import java.util.UUID;

public interface FlightService {
    FlightResponse getFlightById(UUID flightId);
    FlightResponse createMultiLegFlight(CreateFlightRequest request);
}
