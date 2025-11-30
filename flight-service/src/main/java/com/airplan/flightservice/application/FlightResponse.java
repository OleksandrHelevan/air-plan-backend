package com.airplan.flightservice.application;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public record FlightResponse(
        UUID id,
        String code,
        double totalPrice,
        Duration totalDuration,
        List<FlightSegmentResponse> segments
) {}
