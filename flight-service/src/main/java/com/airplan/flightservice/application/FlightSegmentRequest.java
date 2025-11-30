package com.airplan.flightservice.application;


public record FlightSegmentRequest(
        String from,
        String to,
        double price,
        String duration
) {}