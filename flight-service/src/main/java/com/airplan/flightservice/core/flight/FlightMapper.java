package com.airplan.flightservice.core.flight;

import com.airplan.flightservice.application.CreateFlightRequest;
import com.airplan.flightservice.application.FlightResponse;
import com.airplan.flightservice.application.FlightSegmentRequest;
import com.airplan.flightservice.application.FlightSegmentResponse;
import com.airplan.flightservice.config.MapperConfig;
import com.airplan.flightservice.domains.flight.Flight;
import com.airplan.flightservice.domains.flight.FlightSegment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface FlightMapper {

    @Mapping(target = "totalPrice", expression = "java(flight.getPrice())")
    @Mapping(target = "totalDuration", expression = "java(flight.getDuration())")
    FlightResponse toResponse(Flight flight);

    List<FlightResponse> toResponseList(List<Flight> flights);

    FlightSegmentResponse toSegmentResponse(FlightSegment segment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "segments", ignore = true)
    Flight toFlight(CreateFlightRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "duration", expression = "java(java.time.Duration.parse(req.duration()))")
    FlightSegment toSegment(FlightSegmentRequest req);


}

