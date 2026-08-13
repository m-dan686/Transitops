package com.transitops.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    private String source;

    private String destination;

    private String tripDate;

    private String status;

    private String tripNumber;

    private Double cargoWeight;

    private Double plannedDistance;

    private Double actualDistance;

    private Double fuelConsumed;

    private java.time.LocalDateTime createdAt;

    private java.time.LocalDateTime dispatchedAt;

    private java.time.LocalDateTime completedAt;
}