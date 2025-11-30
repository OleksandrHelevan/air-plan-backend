package com.airplan.flightservice.api;

import com.airplan.flightservice.application.CreateFlightRequest;
import com.airplan.flightservice.core.flight.FlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.airplan.flightservice.application.FlightResponse;
import com.airplan.flightservice.core.flight.FlightServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightServiceImpl service;

    @PostMapping
    public ResponseEntity<FlightResponse> createFlight(@RequestBody CreateFlightRequest request) {
        FlightResponse response = service.createMultiLegFlight(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getFlight(@PathVariable UUID id) {
        FlightResponse response = service.getFlightById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
