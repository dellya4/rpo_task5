package com.example.demo.mockAPITest;

import com.example.demo.entity.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import com.example.demo.services.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class OrderServiceApiMockTest {

    @Mock
    private WeatherService weatherService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductService productService;

    @InjectMocks
    private OrderService orderService;

    @Test
    void shouldHandleApiFailure() {
        User user = new User(1L, "Adel", "City");

        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
        when(weatherService.getWeather(any())).thenThrow(new RuntimeException("API down"));

        assertThrows(RuntimeException.class,
                () -> orderService.createOrder(1L));
    }
}
