package com.exposit.ui.action.customer;

import com.exposit.model.Customer;

import java.util.Scanner;

public class RegisterCustomerAction extends AbstractCustomerAction {

    @Override
    public void execute() {
        System.out.println("Enter the name of customer:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter the email of customer:");
        String email = scanner.nextLine();
        customerService.add(new Customer(name, email));
    }
}
