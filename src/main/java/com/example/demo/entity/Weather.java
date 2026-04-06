package com.example.demo.entity;

import com.example.demo.enums.WeatherCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private double temperature;
    private WeatherCondition condition;
}
