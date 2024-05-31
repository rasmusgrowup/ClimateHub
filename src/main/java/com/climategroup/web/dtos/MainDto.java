package com.climategroup.web.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainDto {
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;
    private int seaLevel;
    private int grndLevel;
}
