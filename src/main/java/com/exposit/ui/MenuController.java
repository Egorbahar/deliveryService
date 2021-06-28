package com.exposit.ui;

import java.util.Scanner;

public class MenuController {
    private static MenuController instance;
    private Builder builder;
    private Navigator navigator;
    private static final Integer EXIT_OPTION = 4;

    private MenuController() {
        builder = Builder.getInstance();
        builder.buildMenu();
        navigator = Navigator.getInstance();
    }

    public static MenuController getInstance() {
        if (instance == null) {
            instance = new MenuController();
        }
        return instance;
    }

    public void run() {
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        Integer index = null;
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        while (!EXIT_OPTION.equals(index)) {
            try {
                index = scanner.nextInt();
                navigator.navigate(index);
                navigator.printMenu();
            } catch (Exception ex){
                System.out.println(String.format("Exception occurred: %s. Please try again", ex.toString()));
                navigator.printMenu();
            }
            finally {
                index = 0;
                scanner.nextLine();
            }
        }
    }
}
