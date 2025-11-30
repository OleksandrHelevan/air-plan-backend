package com.airplan.flightservice.domains.flight;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "flights")
@Getter
@Setter
public class Flight implements FlightUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightSegment> segments = new ArrayList<>();

    public void addSegment(FlightSegment segment) {
        segment.setParent(this);
        segments.add(segment);
    }

    @Override
    public double getPrice() {
        return segments.stream()
                .mapToDouble(FlightSegment::getPrice)
                .sum();
    }

    @Override
    public Duration getDuration() {
        return segments.stream()
                .map(FlightSegment::getDuration)
                .reduce(Duration.ZERO, Duration::plus);
    }
}

