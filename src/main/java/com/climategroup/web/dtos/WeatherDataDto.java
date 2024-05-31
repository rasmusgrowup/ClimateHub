package com.climategroup.web.dtos;

import com.climategroup.web.models.*;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class WeatherDataDto {
    private Long id;
    private Location location;
    private List<Weather> weather;
    private Coordinates coord;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int cod;
}
