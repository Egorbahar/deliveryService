package com.exposit.api.service;

import com.exposit.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);

    void deleteOrder(Order order);

    List<Order> getAll();

    void deleteOrderByCustomerId(Long id);

    List<Order> getAllByCustomerId(Long customerId);
}
