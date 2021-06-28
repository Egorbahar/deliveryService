package com.exposit.ui.action.product;

import java.util.*;
import java.util.stream.Collectors;

public class FindByAttributesAction extends AbstractProductAction {

    @Override
    public void execute() {
        System.out.println("Select one or several attributes (by space):");
        System.out.println("1.Name" + "\n" + "2.Price" + "\n" + "3.Store");
        Map<Integer, String> attributes = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String buffer;
        try {
            buffer = scanner.nextLine();
            List<Integer> options = Arrays
                    .stream(buffer.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int option : options) {
                switch (option) {
                    case 1:
                        System.out.println("Enter the name of product");
                        scanner = new Scanner(System.in);
                        attributes.put(option, scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter the price of product");
                        scanner = new Scanner(System.in);
                        attributes.put(option, scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter the name of store");
                        scanner = new Scanner(System.in);
                        attributes.put(option, scanner.nextLine());
                        break;
                    default:
                        System.out.println("Incorrect input");
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getCause().toString());

        }
        System.out.println(productService.findByAttributes(attributes));

    }
}
