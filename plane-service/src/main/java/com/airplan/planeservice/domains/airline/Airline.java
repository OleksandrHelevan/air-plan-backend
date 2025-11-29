package com.airplan.planeservice.domains.airline;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "airlines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 150)
    private String name;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(name="app_rating")
    private Double rating;

    @Column(name = "founded_year")
    private Integer foundedYear;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
}
