package com.exposit.ui.action.store;

import com.exposit.ui.Builder;
import com.exposit.ui.Navigator;

public class NextStoreMenuAction extends AbstractStoreAction {
    @Override
    public void execute() {
        Navigator.getInstance().setCurrentMenu(Builder.getInstance().createMenu("Store menu"));
    }
}
