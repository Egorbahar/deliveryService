package com.exposit.ui.action.product;

import com.exposit.enums.CategoryItem;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindByCategoryAction extends AbstractProductAction {

    @Override
    public void execute() {
        System.out.println("Available categories:\n" + CategoryItem.printAll());
        Scanner scanner = new Scanner(System.in);
        String buffer;
        System.out.println("Enter the category of product(one or several by space) ");
        try {
            buffer = scanner.nextLine();

            List<Integer> numbers = Arrays
                    .stream(buffer.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            searchByCategories(numbers);

        } catch (Exception exception) {
            System.out.println("Incorrect input");
            scanner.nextLine();
        }
    }

    public void searchByCategories(List<Integer> categories) {
        System.out.println(productService.findByCategories(categories));
    }
}
