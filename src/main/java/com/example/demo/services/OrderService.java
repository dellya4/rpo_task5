package com.example.demo.services;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.entity.Weather;
import com.example.demo.enums.Product;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final WeatherService weatherService;
    private final ProductService productService;

    @Transactional
    public Order createOrder(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Weather weather = weatherService.getWeather(user.getCity());
        Product product = productService.suggestProduct(weather);

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);

        return orderRepository.save(order);
    }
}
