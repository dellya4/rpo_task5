package com.example.demo.services;

import com.example.demo.entity.Weather;
import com.example.demo.enums.WeatherCondition;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    public Weather getWeather(String city) {
        if ("RainCity".equalsIgnoreCase(city)) return new Weather(15.0, WeatherCondition.RAIN);
        if ("SunnyCity".equalsIgnoreCase(city)) return new Weather(27.0, WeatherCondition.SUNNY);
        if ("SnowCity".equalsIgnoreCase(city)) return new Weather(-10.0, WeatherCondition.SNOW);
        return new Weather(5.0, WeatherCondition.RAIN);
    }
}
