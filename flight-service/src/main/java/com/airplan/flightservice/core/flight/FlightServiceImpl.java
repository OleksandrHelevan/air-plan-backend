package com.airplan.flightservice.core.flight;

import com.airplan.flightservice.application.CreateFlightRequest;
import com.airplan.flightservice.application.FlightResponse;
import com.airplan.flightservice.core.persistance.FlightRepository;
import com.airplan.flightservice.core.util.ErrorMessage;
import com.airplan.flightservice.domains.flight.Flight;
import com.airplan.flightservice.domains.flight.FlightSegment;
import com.airplan.flightservice.domains.flight.FlightService;
import com.airplan.flightservice.exception.FlightNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Transactional
    public FlightResponse createMultiLegFlight(CreateFlightRequest request) {

        Flight flight = flightMapper.toFlight(request);

        List<FlightSegment> segments = request.segments().stream()
                .map(flightMapper::toSegment)
                .toList();

        segments.forEach(flight::addSegment);

        return flightMapper.toResponse(flightRepository.save(flight));
    }

    @Transactional(readOnly = true)
    public FlightResponse getFlightById(UUID flightId) {
        Flight flight = flightRepository
                .findById(flightId).orElseThrow(() -> new FlightNotFoundException(ErrorMessage.FLIGHT_NOT_FOUND));
        return flightMapper.toResponse(flight);
    }
}
