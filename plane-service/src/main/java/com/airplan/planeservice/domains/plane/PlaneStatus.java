package com.airplan.planeservice.domains.plane;

import lombok.Getter;


@Getter
public enum PlaneStatus implements PlaneStatusStrategy {

    NO_SEATS_AVAILABLE {
        @Override
        public PlaneStatus nextAction() {
            return IN_FLIGHT;
        }
    },
    IN_FLIGHT {
        @Override
        public PlaneStatus nextAction() {
            return INSPECTION;
        }
    },
    REPAIR {
        @Override
        public PlaneStatus nextAction() {
            return INSPECTION;
        }
    },
    INSPECTION {
        @Override
        public PlaneStatus nextAction() {
            return FREE_TO_USE;
        }
    },
    OUT_OF_SERVICE {
        @Override
        public PlaneStatus nextAction() {
            return DECOMMISSIONED;
        }
    },
    RESERVED {
        @Override
        public PlaneStatus nextAction() {
            return IN_FLIGHT;
        }
    },
    DECOMMISSIONED {
        @Override
        public PlaneStatus nextAction() {
            return DECOMMISSIONED;
        }
    },
    FREE_TO_USE {
        @Override
        public PlaneStatus nextAction() {
            return RESERVED;
        }
    };

    public abstract PlaneStatus nextAction();

}
