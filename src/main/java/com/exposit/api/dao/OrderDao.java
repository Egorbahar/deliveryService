package com.exposit.api.dao;

import com.exposit.model.Order;

import java.util.List;

public interface OrderDao {
    void save(Order order);

    Order getById(Long id);

    List<Order> getAll();

    void delete(Order order);

    void delete(Long id);
}
