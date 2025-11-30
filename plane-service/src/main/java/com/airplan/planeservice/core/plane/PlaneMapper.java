package com.airplan.planeservice.core.plane;

import com.airplan.planeservice.application.plane.PlaneResponse;
import com.airplan.planeservice.config.MapperConfig;
import com.airplan.planeservice.domains.plane.Plane;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface PlaneMapper {
    PlaneResponse toDto(Plane plane);
}
