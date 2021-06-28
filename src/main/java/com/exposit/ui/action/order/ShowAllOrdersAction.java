package com.exposit.ui.action.order;

public class ShowAllOrdersAction extends AbstractOrderAction {

    @Override
    public void execute() {
        orderService.getAll().forEach(System.out::println);
    }
}
