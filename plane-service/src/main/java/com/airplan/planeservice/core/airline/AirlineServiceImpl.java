package com.airplan.planeservice.core.airline;

import com.airplan.planeservice.core.util.ErrorMessage;
import com.airplan.planeservice.exception.AirlineNotFoundException;
import com.airplan.planeservice.domains.airline.Airline;
import lombok.RequiredArgsConstructor;
import com.airplan.planeservice.application.airline.AirlineResponse;
import com.airplan.planeservice.application.airline.CreateAirlineRequest;
import com.airplan.planeservice.domains.airline.AirlineService;
import com.airplan.planeservice.core.persistence.AirlineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AirlineServiceImpl implements AirlineService {
    private final AirlineRepository airplaneRepository;
    private final AirlineMapper airlineMapper;

    @Override
    @Transactional
    public AirlineResponse createAirline(CreateAirlineRequest request) {
        Airline airline = Airline
                .builder()
                .name(request.getName())
                .country(request.getCountry())
                .foundedYear(request.getFoundedYear())
                .description(request.getDescription())
                .build();
        return airlineMapper
                .toDto(airplaneRepository.save(airline));
    }

    @Override
    public AirlineResponse getAirlineById(UUID id) {
        Airline airline = airplaneRepository
                .findById(id)
                .orElseThrow(() -> new AirlineNotFoundException(ErrorMessage.AIRLINE_NOT_FOUND));
        return airlineMapper.toDto(airline);
    }

}
