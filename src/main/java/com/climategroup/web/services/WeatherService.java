package com.climategroup.web.services;

import com.climategroup.web.util.GeoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherData(String city) {
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

            return restTemplate.getForObject(weatherUrl, String.class);
        }
        return "Location not found";
    }
}

