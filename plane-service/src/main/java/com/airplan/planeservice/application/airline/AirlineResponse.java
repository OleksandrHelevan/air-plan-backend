package com.airplan.planeservice.application.airline;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirlineResponse {

    private UUID id;

    private String name;

    private String country;

    private Double rating;

    private Integer foundedYear;

}
