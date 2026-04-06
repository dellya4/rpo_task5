package com.example.demo.serviceTest;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.entity.Weather;
import com.example.demo.enums.Product;
import com.example.demo.enums.WeatherCondition;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import com.example.demo.services.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private WeatherService weatherService;

    @Mock
    private ProductService productService;

    @InjectMocks
    private OrderService orderService;

    @Test
    void shouldCreateOrderSuccessfully() {
        User user = new User(1L, "Asel", "SunnyCity");
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
        when(weatherService.getWeather("SunnyCity"))
                .thenReturn(new Weather(25, WeatherCondition.SUNNY));
        when(productService.suggestProduct(any()))
                .thenReturn(Product.SUNGLASSES);

        Order order = new Order();
        order.setId(1L);

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.createOrder(1L);
        assertNotNull(result);
        verify(orderRepository).save(any(Order.class));
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class,
                () -> orderService.createOrder(1L));
    }
}
