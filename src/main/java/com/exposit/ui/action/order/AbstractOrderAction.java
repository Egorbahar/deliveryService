package com.exposit.ui.action.order;

import com.exposit.api.dao.CustomerDao;
import com.exposit.api.dao.OrderDao;
import com.exposit.api.dao.ProductDao;
import com.exposit.api.dao.StoreDao;
import com.exposit.api.service.CustomerService;
import com.exposit.api.service.OrderService;
import com.exposit.api.service.ProductService;
import com.exposit.api.service.StoreService;
import com.exposit.dao.CustomerDaoImpl;
import com.exposit.dao.OrderDaoImpl;
import com.exposit.dao.ProductDaoImpl;
import com.exposit.dao.StoreDaoImpl;
import com.exposit.service.CustomerServiceImpl;
import com.exposit.service.OrderServiceImpl;
import com.exposit.service.ProductServiceImpl;
import com.exposit.service.StoreServiceImpl;
import com.exposit.ui.action.Action;

public abstract class AbstractOrderAction implements Action {

    protected static final OrderDao orderDao = new OrderDaoImpl();
    protected static final OrderService orderService = new OrderServiceImpl(orderDao);
    protected static final StoreDao storeDao = new StoreDaoImpl();
    protected static final StoreService storeService = new StoreServiceImpl(storeDao);
    protected static final ProductDao productDao = new ProductDaoImpl();
    protected static final ProductService productService = new ProductServiceImpl(productDao);
    protected static final CustomerDao customerDao = new CustomerDaoImpl();
    protected static final CustomerService customerService = new CustomerServiceImpl(customerDao);
}
