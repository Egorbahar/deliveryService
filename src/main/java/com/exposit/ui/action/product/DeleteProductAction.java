package com.exposit.ui.action.product;

import com.exposit.model.Product;
import com.exposit.model.Store;

import java.util.Scanner;

public class DeleteProductAction extends AbstractProductAction {

    @Override
    public void execute() {
        System.out.println("Enter the store id:");
        storeService.getAll().forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        Long storeId = scanner.nextLong();
        productService.getAllByStoreId(storeId).forEach(System.out::println);
        System.out.println("Enter the  product id:");
        scanner = new Scanner(System.in);
        Long productId = scanner.nextLong();
        Store store = storeService.getAll().stream()
                                  .filter(s -> s.getId().equals(storeId))
                                  .findFirst()
                                  .get();
        store.getProducts().remove(productService.deleteProduct(new Product(productId)));
        storeService.updateStore(store);
    }
}
