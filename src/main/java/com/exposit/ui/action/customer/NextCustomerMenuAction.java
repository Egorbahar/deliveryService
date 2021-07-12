package com.exposit.ui.action.customer;

import com.exposit.ui.menu.Builder;
import com.exposit.ui.menu.Navigator;

public class NextCustomerMenuAction extends AbstractCustomerAction {
    @Override
    public void execute() {
        Navigator.getInstance().setCurrentMenu(Builder.getInstance().createMenu("Customer menu"));
    }
}
