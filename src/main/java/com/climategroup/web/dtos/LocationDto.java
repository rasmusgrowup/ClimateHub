package com.climategroup.web.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String region;
    private String country;
}
