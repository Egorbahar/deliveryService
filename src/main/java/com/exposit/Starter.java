package com.exposit;

import com.exposit.ui.MenuController;

public class Starter {

    public static void main(String[] args) {
        try {
            MenuController.getInstance().run();
        } catch (Exception ex) {
            System.out.println(String.format("Exception occurred: %s", ex.getCause()));
        }
    }
}
