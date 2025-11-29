package com.airplan.planeservice.domains.airline;

import com.airplan.planeservice.application.airline.AirlineResponse;
import com.airplan.planeservice.application.airline.CreateAirlineRequest;

import java.util.UUID;

public interface AirlineService {
    AirlineResponse createAirline(CreateAirlineRequest request);
    AirlineResponse getAirlineById(UUID id);
}
