package com.exposit.api.dao;

import com.exposit.model.Customer;

import java.util.List;

public interface CustomerDao {
    void save(Customer customer);

    Customer getById(Long id);

    List<Customer> getAll();

    void delete(Customer customer);

    Customer update(Customer customerUp);
}
