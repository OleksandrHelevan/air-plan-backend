package com.airplan.planeservice.core.airline;

import com.airplan.planeservice.application.airline.AirlineResponse;
import com.airplan.planeservice.config.MapperConfig;
import com.airplan.planeservice.domains.airline.Airline;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface AirlineMapper {
    AirlineResponse toDto(Airline airline);
}
