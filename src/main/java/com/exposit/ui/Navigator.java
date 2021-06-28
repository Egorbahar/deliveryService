package com.exposit.ui;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Navigator {
    private static Navigator instance;
    private Menu currentMenu;

    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }

    public void printMenu() {
        System.out.println(currentMenu.getName());
        currentMenu.getMenuItems().forEach(System.out::println);
    }

    public void navigate(int index) {
        if (currentMenu != null) {
            MenuItem menuItem = currentMenu.getMenuItems().get(index - 1);
            menuItem.doAction();
        }
    }
}
