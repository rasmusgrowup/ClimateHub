package com.climategroup.web.services;

import com.climategroup.web.dtos.WeatherDataDto;

public interface WeatherDataService {
    WeatherDataDto createWeatherData(WeatherDataDto weatherDataDto);
    WeatherDataDto getWeatherData(String city);
}