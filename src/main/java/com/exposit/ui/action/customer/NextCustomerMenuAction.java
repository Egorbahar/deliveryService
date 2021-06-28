package com.exposit.ui.action.customer;

import com.exposit.ui.Builder;
import com.exposit.ui.Navigator;

public class NextCustomerMenuAction extends AbstractCustomerAction {
    @Override
    public void execute() {
        Navigator.getInstance().setCurrentMenu(Builder.getInstance().createMenu("Customer menu"));
    }
}
