package com.climategroup.web.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysDto {
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;
}