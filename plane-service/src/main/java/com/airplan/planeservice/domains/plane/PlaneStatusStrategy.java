package com.airplan.planeservice.domains.plane;

public interface PlaneStatusStrategy {
    PlaneStatus nextAction();

    default void performAction(Plane plane) {
        plane.setStatus(nextAction());
    }
}
