package com.airplan.planeservice.application.plane;

import com.airplan.planeservice.application.airline.AirlineResponse;
import com.airplan.planeservice.domains.plane.PlaneStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class PlaneResponse {
    private UUID id;
    private String model;
    private String manufacturer;
    private int seatCount;
    private int rangeKm;
    private int productionYear;
    private PlaneStatus status;
    private AirlineResponse airline;
}
