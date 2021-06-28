package com.exposit.ui.action;

public class Exit implements Action {
    @Override
    public void execute() {
        System.out.println("Good Bye!!");
        System.exit(0);
    }
}
