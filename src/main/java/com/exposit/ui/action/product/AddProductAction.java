package com.exposit.ui.action.product;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.service.CategoryService;
import com.exposit.dao.CategoryDaoImpl;
import com.exposit.enums.CategoryItem;
import com.exposit.model.Category;
import com.exposit.model.Product;
import com.exposit.model.Store;
import com.exposit.service.CategoryServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddProductAction extends AbstractProductAction {
    private static final CategoryDao categoryDao = new CategoryDaoImpl();
    private static final CategoryService categoryService = new CategoryServiceImpl(categoryDao);

    @Override
    public void execute() {
        storeService.getAll().forEach(System.out::println);
        System.out.println("Enter the  store id:");
        Scanner scanner = new Scanner(System.in);
        Long storeId = scanner.nextLong();
        System.out.println("Enter the name of product:");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter the price of product:");
        scanner = new Scanner(System.in);
        Double price = scanner.nextDouble();
        System.out.println("Enter the quantity of product:");
        scanner = new Scanner(System.in);
        Integer quantity = scanner.nextInt();
        Store store = storeService.getById(storeId);
        System.out.println("Available categories:\n" + CategoryItem.printAll());
        System.out.println("Enter the categories of product:");
        List<Category> categories = new ArrayList<>();
        String buffer;
        scanner = new Scanner(System.in);
        try {
            buffer = scanner.nextLine();

            List<Integer> selectedCategories = Arrays
                    .stream(buffer.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int selectedCategoryIndex : selectedCategories) {
                categories.add(new Category(CategoryItem.getByIndex(selectedCategoryIndex)));
            }
        } catch (Exception exception) {
            System.out.println("Incorrect input");
        }
        Product product = new Product(name, quantity, categories, price, store);
        Product prod = productService.addProduct(product);
        for (Category category : categories) {
            category.setProductId(prod.getId());
            categoryService.save(category);
        }
        store.getProducts().add(productService.getAll().stream()
                                              .filter(p -> p.getId().equals(prod.getId()))
                                              .findFirst()
                                              .get());
        storeService.updateStore(store);
    }
}
