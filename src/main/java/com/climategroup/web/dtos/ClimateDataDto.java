package com.climategroup.web.dtos;

import com.climategroup.web.models.Location;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ClimateDataDto {
    private Long id;
    private Location location;

    private Date date;
    private Double temperature;
    private Double precipitation;
    private Double humidity;
    private Double windSpeed;
    private Double seaLevel;
}
