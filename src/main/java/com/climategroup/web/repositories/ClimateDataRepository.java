package com.climategroup.web.repositories;

import com.climategroup.web.models.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimateDataRepository extends JpaRepository<WeatherData, Long> {
}
