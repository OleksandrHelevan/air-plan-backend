package com.airplan.planeservice.application.plane;

import com.airplan.planeservice.domains.plane.PlaneStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CreatePlaneRequest {
    @NotNull
    private String model;

    @NotNull
    private String manufacturer;

    @NotNull
    @Min(1)
    private int seatCount;

    @NotNull
    @Min(1)
    private int rangeKm;

    @NotNull
    private int productionYear;

    private PlaneStatus status;

    @NotNull
    private UUID airlineId;
}
