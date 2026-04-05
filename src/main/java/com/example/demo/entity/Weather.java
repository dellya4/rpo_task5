package com.example.demo.entity;

import com.example.demo.enums.WeatherCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Weather {
    private double temperature;
    private WeatherCondition condition;
}
