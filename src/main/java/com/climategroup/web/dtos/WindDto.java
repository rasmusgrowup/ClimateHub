package com.climategroup.web.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WindDto {
    private double speed;
    private int deg;
    private double gust;
}
