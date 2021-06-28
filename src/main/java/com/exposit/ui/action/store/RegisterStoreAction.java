package com.exposit.ui.action.store;

import com.exposit.model.Store;

import java.io.IOException;
import java.util.Scanner;

public class RegisterStoreAction extends AbstractStoreAction {

    @Override
    public void execute() {
        System.out.println("Enter the name of store:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter the address of store:");
        String address = scanner.nextLine();
        try {
            storeService.add(new Store(name, address));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
