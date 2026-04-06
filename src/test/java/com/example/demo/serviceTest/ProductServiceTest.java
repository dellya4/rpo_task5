package com.example.demo.serviceTest;

import com.example.demo.entity.Weather;
import com.example.demo.enums.Product;
import com.example.demo.enums.WeatherCondition;
import com.example.demo.services.ProductService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {

    private final ProductService productService = new ProductService();

    @Test
    void shouldReturnUmbrellaWhenRain() {
        Weather weather = new Weather(10, WeatherCondition.RAIN);
        Product product = productService.suggestProduct(weather);

        assertEquals(Product.UMBRELLA, product);
    }

    @Test
    void shouldReturnUmbrellaWhenSunny() {
        Weather weather = new Weather(25, WeatherCondition.SUNNY);
        Product product = productService.suggestProduct(weather);

        assertEquals(Product.SUNGLASSES, product);
    }

    @Test
    void shouldReturnUmbrellaWhenSnow() {
        Weather weather = new Weather(-10, WeatherCondition.SNOW);
        Product product = productService.suggestProduct(weather);

        assertEquals(Product.JACKET, product);
    }

}
