package com.exposit.ui;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SubmenuItems {
    STORES("Store menu"),
    ORDERS("Order menu"),
    CUSTOMERS("Customer menu"),
    NOT_FOUND("Not found");

    private String title;

    public static SubmenuItems fromValue(String value) {
        for (final SubmenuItems item : values()) {
            if (item.title.equalsIgnoreCase(value)) {
                return item;
            }
        }
        return NOT_FOUND;
    }
}
