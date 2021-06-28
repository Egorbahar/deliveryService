package com.exposit.ui.action.order;

import com.exposit.ui.Builder;
import com.exposit.ui.Navigator;

public class NextOrderMenuAction extends AbstractOrderAction {
    @Override
    public void execute() {
        Navigator.getInstance().setCurrentMenu(Builder.getInstance().createMenu("Order menu"));
    }
}
