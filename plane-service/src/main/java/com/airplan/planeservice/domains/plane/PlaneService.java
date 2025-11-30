package com.airplan.planeservice.domains.plane;

import com.airplan.planeservice.application.plane.CreatePlaneRequest;
import com.airplan.planeservice.application.plane.PlaneResponse;

import java.util.UUID;

public interface PlaneService {
    PlaneResponse createPlane(CreatePlaneRequest request);
    PlaneResponse getPlane(UUID planeId);
    PlaneResponse changeStatus (UUID planeId, PlaneStatus newStatus);
}
