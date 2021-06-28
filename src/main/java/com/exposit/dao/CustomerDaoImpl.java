package com.exposit.dao;

import com.exposit.api.dao.CustomerDao;
import com.exposit.model.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private final static String FILE_PATH = "/src/main/java/com/exposit/dao/json/Customers.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId((long) (Math.random() * 100));
        }
        List<Customer> customers = getAll();
        customers.add(customer);
        writeFile(customers);
    }

    public Customer getById(Long id) {
        return getAll().stream()
                       .filter(c -> c.getId().equals(id)).findFirst().orElse(null);//написать ex
    }

    public List<Customer> getAll() {
        BufferedReader bufferedReader = null;
        try {
            String absolutePath = new File("").getAbsolutePath();
            bufferedReader = new BufferedReader(new FileReader(absolutePath + FILE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type type = new TypeToken<List<Customer>>() {
        }.getType();
        List<Customer> customers = gson.fromJson(bufferedReader, type);
        return customers;
    }

    public void delete(Customer customer) {
        List<Customer> customers = getAll();
        Customer deleteCustomer = customers.stream()
                                           .filter(c -> c.getId().equals(customer.getId()))
                                           .findFirst()
                                           .get();
        customers.remove(deleteCustomer);
        writeFile(customers);
    }

    public Customer update(Customer customerUp) {
        Customer customer = getById(customerUp.getId());
        List<Customer> updateList = getAll();
        updateList.set(updateList.indexOf(customer), customerUp);
        writeFile(updateList);
        return customer;
    }

    public void writeFile(List<Customer> list) {
        String absolutePath = new File("").getAbsolutePath();
        try (FileWriter writer = new FileWriter(absolutePath + FILE_PATH)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
