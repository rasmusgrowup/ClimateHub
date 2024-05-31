package com.climategroup.web.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoordinatesDto {
    private double lon;
    private double lat;
}
