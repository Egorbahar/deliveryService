package com.exposit.ui.action.customer;

import com.exposit.api.dao.CustomerDao;
import com.exposit.api.dao.OrderDao;
import com.exposit.api.service.CustomerService;
import com.exposit.api.service.OrderService;
import com.exposit.dao.CustomerDaoImpl;
import com.exposit.dao.OrderDaoImpl;
import com.exposit.service.CustomerServiceImpl;
import com.exposit.service.OrderServiceImpl;
import com.exposit.ui.action.Action;

public abstract class AbstractCustomerAction implements Action {
    protected static final CustomerDao customerDao = new CustomerDaoImpl();
    protected static final OrderDao orderDao = new OrderDaoImpl();
    protected static final CustomerService customerService = new CustomerServiceImpl(customerDao);
    protected static final OrderService orderService = new OrderServiceImpl(orderDao);
}
