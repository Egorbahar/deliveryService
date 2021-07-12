package com.exposit.ui.action.store;

import com.exposit.ui.menu.Builder;
import com.exposit.ui.menu.Navigator;

public class NextStoreMenuAction extends AbstractStoreAction {
    @Override
    public void execute() {
        Navigator.getInstance().setCurrentMenu(Builder.getInstance().createMenu("Store menu"));
    }
}
