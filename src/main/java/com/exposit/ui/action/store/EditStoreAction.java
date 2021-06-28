package com.exposit.ui.action.store;

import com.exposit.model.Store;

import java.util.Scanner;

public class EditStoreAction extends AbstractStoreAction {

    @Override
    public void execute() {
        System.out.println("Enter the store id:");
        storeService.getAll().forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        Long storeId = scanner.nextLong();
        System.out.println("Enter the new name of store:");
        String nameNew = scanner.nextLine();
        System.out.println("Enter the new address of store:");
        String addressNew = scanner.nextLine();
        Store store = storeService.getById(storeId);
        store.setName(nameNew);
        store.setAddress(addressNew);
        storeService.updateStore(store);
    }
}
