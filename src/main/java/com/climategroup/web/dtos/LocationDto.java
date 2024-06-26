package com.climategroup.web.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {
    private Long id;
    private String name;
    private String country;
}
