package com.airplan.planeservice.domains.plane;

import com.airplan.planeservice.domains.airline.Airline;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "planes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "model", nullable = false, length = 150)
    private String model;

    @Column(name = "manufacturer", nullable = false, length = 150)
    private String manufacturer;

    @Column(name = "seat_count", nullable = false)
    private int seatCount;

    @Column(name = "range_km", nullable = false)
    private int rangeKm;

    @Column(name = "production_year", nullable = false)
    private int productionYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 50)
    private PlaneStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", foreignKey = @ForeignKey(name = "fk_planes_airlines"))
    private Airline airline;


}
