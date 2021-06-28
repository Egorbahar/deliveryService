package com.exposit.ui.action.order;

import com.exposit.model.Customer;
import com.exposit.model.Order;
import com.exposit.model.Product;
import com.exposit.model.Store;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddOrderAction extends AbstractOrderAction {

    @Override
    public void execute() {
        storeService.getAll().forEach(System.out::println);
        System.out.println("Enter the store id:");
        Scanner scanner = new Scanner(System.in);
        Long storeId = scanner.nextLong();
        productService.getAll().stream()
                      .filter(product -> product.getStore().getId().equals(storeId))
                      .forEach(System.out::println);
        System.out.println("Enter the product id:");
        scanner = new Scanner(System.in);
        Long productId = scanner.nextLong();
        System.out.println("Enter the quantity of product:");
        scanner = new Scanner(System.in);
        Integer quantityProd = scanner.nextInt();
        customerService.getAll().forEach(System.out::println);
        System.out.println("Enter the  customer id:");
        scanner = new Scanner(System.in);
        Long customerId = scanner.nextLong();
        Customer customer = customerService.getById(customerId);
        Product product = productService.getById(productId);
        Store store = storeService.getById(storeId);
        int index = store.getProducts().indexOf(product);
        Integer currentQuantity = product.getQuantity();
        product.setQuantity(currentQuantity - quantityProd);
        productService.updateProduct(product);
        store.getProducts().set(index, product);
        storeService.updateStore(store);
        System.out.println("Enter the delivery date(dd-MM-yyyy):");
        scanner = new Scanner(System.in);
        LocalDate localDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        orderService.addOrder(new Order(product.getName(), quantityProd, customer, store, localDate));
    }
}
