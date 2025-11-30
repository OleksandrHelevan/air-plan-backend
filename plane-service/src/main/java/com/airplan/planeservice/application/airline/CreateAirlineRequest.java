package com.airplan.planeservice.application.airline;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAirlineRequest {
    @NotNull
    private String name;
    @NotNull
    private String country;

    @NotNull
    @Min(1903)
    @Max(2025)
    private Integer foundedYear;

    private String description;
}

