package com.airplan.flightservice.application;

import java.time.Duration;
import java.util.UUID;

public record FlightSegmentResponse(
        UUID id,
        String from,
        String to,
        double price,
        Duration duration
) {}
