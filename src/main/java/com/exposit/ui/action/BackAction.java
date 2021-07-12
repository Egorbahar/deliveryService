package com.exposit.ui.action;


import com.exposit.ui.menu.Builder;
import com.exposit.ui.menu.Navigator;

public class BackAction implements Action {
    @Override
    public void execute() {
        Navigator.getInstance().setCurrentMenu(Builder.getInstance().getRootMenu());
    }
}

