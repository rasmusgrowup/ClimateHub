package com.climategroup.web.controllers;

import com.climategroup.web.dtos.WeatherDataDto;
import com.climategroup.web.services.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class WeatherController {

    private final WeatherDataService weatherService;

    @Autowired
    public WeatherController(WeatherDataService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/location/{city}")
    public String getWeatherData(@PathVariable String city, Model model) {
        WeatherDataDto weatherData = weatherService.getWeatherData(city);
        model.addAttribute("city", city);
        model.addAttribute("weatherData", weatherData);
        return "weather";
    }
}

