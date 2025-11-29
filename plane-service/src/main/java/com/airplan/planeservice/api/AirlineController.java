package com.airplan.planeservice.api;

import com.airplan.planeservice.application.airline.AirlineResponse;
import com.airplan.planeservice.application.airline.CreateAirlineRequest;
import com.airplan.planeservice.domains.airline.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/airlines")
@RequiredArgsConstructor
public class AirlineController {
    private final AirlineService airlineService;

    @PostMapping
    public ResponseEntity<AirlineResponse> createAirline(@RequestBody CreateAirlineRequest request) {
        AirlineResponse airlineResponse = airlineService.createAirline(request);
        return new ResponseEntity<>(airlineResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity<AirlineResponse> getAirline(@PathVariable("airlineId") UUID airlineId) {
        AirlineResponse airlineResponse = airlineService.getAirlineById(airlineId);
        return new ResponseEntity<>(airlineResponse, HttpStatus.OK);
    }
}