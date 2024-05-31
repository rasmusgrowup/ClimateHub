package com.climategroup.web.services.impl;

import com.climategroup.web.dtos.WeatherDataDto;
import com.climategroup.web.models.WeatherData;
import com.climategroup.web.repositories.WeatherDataRepository;
import com.climategroup.web.services.WeatherDataService;
import com.climategroup.web.util.GeoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final WeatherDataRepository weatherDataRepository;
    private final RestTemplate restTemplate;
    @Value("${openweather.api.key}")
    private String apiKey;

    @Autowired
    public WeatherDataServiceImpl(WeatherDataRepository weatherDataRepository, RestTemplate restTemplate) {
        this.weatherDataRepository = weatherDataRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherDataDto createWeatherData(WeatherDataDto weatherDataDto) {
        return null;
    }

    @Override
    public WeatherDataDto getWeatherData(String city) {
        // Get coordinates for the city
        String geoUrl = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/geo/1.0/direct")
                .queryParam("q", city)
                .queryParam("limit", 1)
                .queryParam("appid", apiKey)
                .toUriString();

        GeoResponse[] geoResponses = restTemplate.getForObject(geoUrl, GeoResponse[].class);
        if (geoResponses != null && geoResponses.length > 0) {
            GeoResponse geoResponse = geoResponses[0];
            double lat = geoResponse.getLat();
            double lon = geoResponse.getLon();

            // Fetch weather data using coordinates
            String weatherUrl = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/data/2.5/weather")
                    .queryParam("lat", lat)
                    .queryParam("lon", lon)
                    .queryParam("appid", apiKey)
                    .toUriString();

            WeatherData weatherData = restTemplate.getForObject(weatherUrl, WeatherData.class);

            if (weatherData == null) {
                return null;
            }

            weatherDataRepository.save(weatherData);
            mapToDto(weatherData);
            return mapToDto(weatherData);
        }
        return null;
    }

    private WeatherDataDto mapToDto(WeatherData weatherData) {
        return WeatherDataDto.builder()
                .id(weatherData.getId())
                .location(weatherData.getLocation())
                .weather(weatherData.getWeather())
                .coord(weatherData.getCoord())
                .base(weatherData.getBase())
                .main(weatherData.getMain())
                .visibility(weatherData.getVisibility())
                .wind(weatherData.getWind())
                .clouds(weatherData.getClouds())
                .dt(weatherData.getDt())
                .sys(weatherData.getSys())
                .timezone(weatherData.getTimezone())
                .cod(weatherData.getCod())
                .build();
    }
}

