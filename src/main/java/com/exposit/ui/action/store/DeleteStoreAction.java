package com.exposit.ui.action.store;

import com.exposit.api.dao.ProductDao;
import com.exposit.api.service.ProductService;
import com.exposit.dao.ProductDaoImpl;
import com.exposit.service.ProductServiceImpl;

import java.util.Scanner;

public class DeleteStoreAction extends AbstractStoreAction {
    private static final ProductDao productDao = new ProductDaoImpl();
    private static final ProductService productService = new ProductServiceImpl(productDao);

    @Override
    public void execute() {
        storeService.getAll().forEach(System.out::println);
        System.out.println("Enter the store id:");
        Scanner scanner = new Scanner(System.in);
        Long storeId = scanner.nextLong();
        storeService.deleteStore(storeId);
        productService.deleteProductByStoreId(storeId);
    }
}
