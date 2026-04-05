package com.example.demo.services;

import com.example.demo.entity.Weather;
import com.example.demo.enums.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product suggestProduct(Weather weather){
        return switch (weather.getCondition()) {
            case RAIN -> Product.UMBRELLA;
            case SUNNY -> Product.SUNGLASSES;
            case SNOW -> Product.JACKET;
        };
    }
}
