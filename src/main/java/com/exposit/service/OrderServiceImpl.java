package com.exposit.service;

import com.exposit.api.dao.OrderDao;
import com.exposit.api.service.OrderService;
import com.exposit.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order addOrder(Order order) {
        orderDao.save(order);
        return order;
    }

    @Override
    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public void deleteOrderByCustomerId(Long id) {
        orderDao.delete(id);
    }

    @Override
    public List<Order> getAllByCustomerId(Long customerId) {
        return orderDao.getAll()
                .stream()
                .filter(o -> o.getCustomer().getId().equals(customerId))
                .collect(Collectors.toList());
    }

}
