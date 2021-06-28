package com.exposit.service;

import com.exposit.api.dao.CustomerDao;
import com.exposit.api.service.CustomerService;
import com.exposit.model.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void add(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerDao.getById(id);
    }
}
