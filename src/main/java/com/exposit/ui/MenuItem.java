package com.exposit.ui;

import com.exposit.ui.action.Action;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuItem {
    private String title;
    private Action action;
    private Menu nextMenu;

    public MenuItem(String title, Action action) {
        this.title = title;
        this.action = action;
    }

    public void doAction() {
        action.execute();
    }

    @Override
    public String toString() {
        return title;
    }
}
