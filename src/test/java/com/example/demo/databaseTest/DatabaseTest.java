package com.example.demo.databaseTest;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.enums.Product;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class DatabaseTest {
    @Autowired
    private OrderService  orderService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void shouldCreateOrderInDB() {
        User user = new  User();
        user.setName("Valeriya");
        user.setCity("SnowCity");

        user = userRepository.save(user);

        Order order = orderService.createOrder(user.getId());

        assertNotNull(order.getId());
        assertEquals(Product.JACKET, order.getProduct());

        assertTrue(orderRepository.findById(order.getId()).isPresent());
    }
}
