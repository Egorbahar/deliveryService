package com.exposit.ui.action.product;

import com.exposit.model.Product;
import com.exposit.model.Store;

import java.util.Scanner;

public class EditProductAction extends AbstractProductAction {

    @Override
    public void execute() {
        storeService.getAll().forEach(System.out::println);
        System.out.println("Enter the  store id:");
        Scanner scanner = new Scanner(System.in);
        Long storeId = scanner.nextLong();
        storeService.getById(storeId).getProducts().forEach(System.out::println);
        System.out.println("Enter the product id:");
        Long productId = scanner.nextLong();
        System.out.println("Enter the new name of product:");
        String nameNew = scanner.nextLine();
        System.out.println("Enter the new quantity of product:");
        Integer quantityNew = scanner.nextInt();
        System.out.println("Enter the new price of product:");
        Double priceNew = scanner.nextDouble();
        Store store = storeService.getAll().stream()
                                  .filter(s -> s.getId().equals(storeId))
                                  .findFirst()
                                  .get();
        Product product = productService.getById(productId);
        int index = store.getProducts().indexOf(product);
        product.setName(nameNew);
        product.setQuantity(quantityNew);
        product.setPrice(priceNew);
        productService.updateProduct(product);
        store.getProducts().set(index, product);
        storeService.updateStore(store);
    }
}
