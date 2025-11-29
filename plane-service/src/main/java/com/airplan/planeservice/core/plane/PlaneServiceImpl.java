package com.airplan.planeservice.core.plane;

import com.airplan.planeservice.application.plane.CreatePlaneRequest;
import com.airplan.planeservice.application.plane.PlaneResponse;
import com.airplan.planeservice.domains.plane.Plane;
import com.airplan.planeservice.core.persistence.PlaneRepository;
import com.airplan.planeservice.core.util.ErrorMessage;
import com.airplan.planeservice.domains.plane.PlaneFactory;
import com.airplan.planeservice.domains.plane.PlaneService;
import com.airplan.planeservice.exception.PlaneNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository planeRepository;
    private final PlaneFactory planeFactory;
    private final PlaneMapper planeMapper;

    @Override
    @Transactional
    public PlaneResponse createPlane(CreatePlaneRequest request) {
        Plane plane = planeFactory.createPlane(request);
        return planeMapper.toDto(planeRepository.save(plane));
    }

    @Override
    @Transactional(readOnly = true)
    public PlaneResponse getPlane(UUID planeId) {
        Plane plane = planeRepository.findById(planeId)
                .orElseThrow(() -> new PlaneNotFoundException(ErrorMessage.PLANE_NOT_FOUND));
        return planeMapper.toDto(plane);
    }
}
