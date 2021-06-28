package com.exposit.ui.action.customer;

import com.exposit.model.Customer;

import java.util.Scanner;

public class DeleteCustomerAction extends AbstractCustomerAction {

    @Override
    public void execute() {
        customerService.getAll().forEach(System.out::println);
        System.out.println("Enter the customer id:");
        Scanner scanner = new Scanner(System.in);
        Long customerId = scanner.nextLong();
        Customer customerDelete = customerService.getById(customerId);
        customerService.deleteCustomer(customerDelete);
        if (!orderService.getAllByCustomerId(customerId).isEmpty()) {
            orderService.deleteOrderByCustomerId(customerId);
        }
    }
}
