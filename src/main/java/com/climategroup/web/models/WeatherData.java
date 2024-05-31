package com.climategroup.web.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private Date date;
    private Double temperature;
    private Double precipitation;
    private Double humidity;
    private Double windSpeed;
    private Double seaLevel;
}

