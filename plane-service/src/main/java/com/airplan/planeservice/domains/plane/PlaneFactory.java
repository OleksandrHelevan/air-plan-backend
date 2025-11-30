package com.airplan.planeservice.domains.plane;

import com.airplan.planeservice.application.plane.CreatePlaneRequest;

public interface PlaneFactory {
    Plane createPlane(CreatePlaneRequest request);
}
