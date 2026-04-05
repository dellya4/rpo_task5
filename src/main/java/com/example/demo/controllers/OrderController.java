package com.example.demo.controllers;

import com.example.demo.entity.Order;
import com.example.demo.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/{userId}")
    public Order addOrder(@PathVariable Long userId) {
        return orderService.createOrder(userId);
    }
}
