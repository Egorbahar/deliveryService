package com.exposit.ui.action.product;

import java.util.Scanner;

public class SortProductByPriceAction extends AbstractProductAction {

    @Override
    public void execute() {
        storeService.getAll().forEach(System.out::println);
        System.out.println("Enter the store id:");
        Scanner scanner = new Scanner(System.in);
        Long storeId = scanner.nextLong();
        productService.sortByPrice(storeId).forEach(System.out::println);
    }
}
