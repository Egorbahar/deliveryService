package com.exposit.ui.action.customer;

import com.exposit.model.Customer;

import java.util.Scanner;

public class EditCustomerAction extends AbstractCustomerAction {

    @Override
    public void execute() {
        System.out.println("Enter the customer id:");
        customerService.getAll().forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        Long customerId = scanner.nextLong();
        System.out.println("Enter the new name of customer:");
        String nameNew = scanner.nextLine();
        System.out.println("Enter the new email of customer:");
        String emailNew = scanner.nextLine();
        Customer customer = customerDao.getById(customerId);
        customer.setName(nameNew);
        customer.setEmail(emailNew);
        customerService.updateCustomer(customer);
    }
}
