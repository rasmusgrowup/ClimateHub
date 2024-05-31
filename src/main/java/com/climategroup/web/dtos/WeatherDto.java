package com.climategroup.web.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherDto {
    private int id;
    private String main;
    private String description;
    private String icon;
}
