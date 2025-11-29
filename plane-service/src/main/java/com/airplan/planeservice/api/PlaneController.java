package com.airplan.planeservice.api;

import com.airplan.planeservice.application.plane.CreatePlaneRequest;
import com.airplan.planeservice.application.plane.PlaneResponse;
import com.airplan.planeservice.domains.plane.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/planes")
@RequiredArgsConstructor
public class PlaneController {
    private final PlaneService planeService;

    @PostMapping
    public ResponseEntity<PlaneResponse> createPlane(@RequestBody CreatePlaneRequest plane) {
        PlaneResponse planeResponse = planeService.createPlane(plane);
        return new ResponseEntity<>(planeResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{planeId}")
    public ResponseEntity<PlaneResponse> getPlane(@PathVariable UUID planeId) {
        PlaneResponse planeResponse = planeService.getPlane(planeId);
        return new ResponseEntity<>(planeResponse, HttpStatus.OK);
    }
}
