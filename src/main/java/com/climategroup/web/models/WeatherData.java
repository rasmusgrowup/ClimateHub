package com.climategroup.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather_data")
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Transient
    private List<Weather> weather;

    @Transient
    private Coordinates coord;
    private String base;

    @Transient
    private Main main;
    private int visibility;

    @Transient
    private Wind wind;

    @Transient
    private Clouds clouds;
    private long dt;

    @Transient
    private Sys sys;
    private int timezone;
    private int cod;
}

