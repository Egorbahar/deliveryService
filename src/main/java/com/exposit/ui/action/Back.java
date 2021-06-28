package com.exposit.ui.action;


import com.exposit.ui.Builder;
import com.exposit.ui.Navigator;

public class Back implements Action {
    @Override
    public void execute() {
        Navigator.getInstance().setCurrentMenu(Builder.getInstance().getRootMenu());
    }
}

