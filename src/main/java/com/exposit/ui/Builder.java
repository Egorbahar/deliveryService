package com.exposit.ui;

import com.exposit.ui.action.Back;
import com.exposit.ui.action.Exit;
import com.exposit.ui.action.customer.DeleteCustomerAction;
import com.exposit.ui.action.customer.EditCustomerAction;
import com.exposit.ui.action.customer.NextCustomerMenuAction;
import com.exposit.ui.action.customer.RegisterCustomerAction;
import com.exposit.ui.action.order.AddOrderAction;
import com.exposit.ui.action.order.NextOrderMenuAction;
import com.exposit.ui.action.order.ShowAllOrdersAction;
import com.exposit.ui.action.product.*;
import com.exposit.ui.action.store.*;

public class Builder {
    private static Builder instance;
    private Menu rootMenu;

    private Builder() {

    }

    public static Builder getInstance() {
        if (instance == null) {
            instance = new Builder();
        }
        return instance;
    }

    public void buildMenu() {
        rootMenu = new Menu();
        rootMenu.setName("Main menu");
        rootMenu.addItem(new MenuItem("1.Stores and Products", new NextStoreMenuAction(), Navigator.getInstance().getCurrentMenu()));
        rootMenu.addItem(new MenuItem("2.Orders", new NextOrderMenuAction(), Navigator.getInstance().getCurrentMenu()));
        rootMenu.addItem(new MenuItem("3.Customers", new NextCustomerMenuAction(), Navigator.getInstance().getCurrentMenu()));
        rootMenu.addItem(new MenuItem("4.Exit", new Exit()));

    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public Menu createMenu(String title) {
        Menu menu = new Menu();
        menu.setName(title);
        SubmenuItems item = SubmenuItems.fromValue(title);
        switch (item) {
            case STORES:
                menu.addItem(new MenuItem("1.Register store", new RegisterStoreAction()));
                menu.addItem(new MenuItem("2.Delete store", new DeleteStoreAction()));
                menu.addItem(new MenuItem("3.View all stores", new ViewAllStoresAction()));
                menu.addItem(new MenuItem("4.Edit the store information", new EditStoreAction()));//
                menu.addItem(new MenuItem("5.Add product", new AddProductAction()));
                menu.addItem(new MenuItem("6.Delete product", new DeleteProductAction()));
                menu.addItem(new MenuItem("7.Edit the product information", new EditProductAction()));
                menu.addItem(new MenuItem("8.Sorting products by price", new SortProductByPriceAction()));
                menu.addItem(new MenuItem("9.Search for products by attributes", new FindByAttributesAction()));
                menu.addItem(new MenuItem("10.Search for products by category", new FindByCategoryAction()));
                menu.addItem(new MenuItem("11.Back", new Back()));
                break;
            case ORDERS:
                menu.addItem(new MenuItem("1.Add order", new AddOrderAction()));
                menu.addItem(new MenuItem("2.Show all orders", new ShowAllOrdersAction()));
                menu.addItem(new MenuItem("3.Back", new Back()));
                break;

            case CUSTOMERS:
                menu.addItem(new MenuItem("1.Register customer", new RegisterCustomerAction()));
                menu.addItem(new MenuItem("2.Delete customer", new DeleteCustomerAction()));
                menu.addItem(new MenuItem("3.Edit the customer information", new EditCustomerAction()));
                menu.addItem(new MenuItem("4.Back", new Back()));//
                break;
        }
        return menu;
    }
}
