package com.climategroup.web.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoResponse {
    private String name;
    private double lat;
    private double lon;
    // Getters and setters
}