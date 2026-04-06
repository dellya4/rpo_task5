package com.example.demo.combinedTest;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.entity.Weather;
import com.example.demo.enums.Product;
import com.example.demo.enums.WeatherCondition;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.OrderService;
import com.example.demo.services.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
@ActiveProfiles("test")
public class CombinedTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserRepository userRepository;

    @MockitoBean
    private WeatherService weatherService;

    @Test
    void shouldCreateOrderWithMockedWeather() {
        User user = new User();
        user.setName("Adel");
        user.setCity("TestCity");

        user = userRepository.save(user);

        when(weatherService.getWeather("TestCity"))
                .thenReturn(new Weather(0, WeatherCondition.SNOW));

        Order order = orderService.createOrder(user.getId());

        assertEquals(Product.JACKET, order.getProduct());
    }
}
