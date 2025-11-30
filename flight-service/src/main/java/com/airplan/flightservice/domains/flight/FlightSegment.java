package com.airplan.flightservice.domains.flight;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.UUID;

@Entity
@Table(name = "flight_segments")
@Getter
@Setter
public class FlightSegment implements FlightUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "\"from\"")
    private String from;

    @Column(name = "\"to\"")
    private String to;
    private double price;
    private Duration duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight parent;

}
