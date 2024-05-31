package com.climategroup.web.dtos;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class CloudsDto {
    private int all;
}