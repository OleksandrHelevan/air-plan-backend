package com.airplan.flightservice.application;

import java.util.List;

public record CreateFlightRequest(
        String code,
        List<FlightSegmentRequest> segments
) {}