package com.exposit.api.service;

import com.exposit.model.Customer;

import java.util.List;

public interface CustomerService {
    void add(Customer customer);

    void deleteCustomer(Customer customer);

    void updateCustomer(Customer customer);

    List<Customer> getAll();

    Customer getById(Long id);
}
