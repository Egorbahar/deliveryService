package com.exposit.ui.action.store;

public class ViewAllStoresAction extends AbstractStoreAction {

    @Override
    public void execute() {
        storeService.getAll().forEach(System.out::println);
    }
}
