package com.airplan.planeservice.core.plane;

import com.airplan.planeservice.application.plane.CreatePlaneRequest;
import com.airplan.planeservice.domains.airline.Airline;
import com.airplan.planeservice.core.persistence.AirlineRepository;
import com.airplan.planeservice.domains.plane.Plane;
import com.airplan.planeservice.core.util.ErrorMessage;
import com.airplan.planeservice.domains.plane.PlaneFactory;
import com.airplan.planeservice.exception.AirlineNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
@RequiredArgsConstructor
public class PlaneFactoryImpl implements PlaneFactory {
    private final AirlineRepository airlineRepository;

    @Override
    public Plane createPlane(CreatePlaneRequest request) {
        Airline airline = airlineRepository
                .findById(request.getAirlineId())
                .orElseThrow(() -> new AirlineNotFoundException(ErrorMessage.AIRLINE_NOT_FOUND));

        return Plane.builder()
                .model(request.getModel())
                .manufacturer(request.getManufacturer())
                .seatCount(request.getSeatCount())
                .rangeKm(request.getRangeKm())
                .productionYear(request.getProductionYear())
                .status(request.getStatus())
                .airline(airline)
                .build();
    }
}
