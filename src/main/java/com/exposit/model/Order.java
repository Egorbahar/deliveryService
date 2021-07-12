package com.exposit.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Order {
    private Long id;
    private String nameProduct;
    private Integer quantityProduct;
    private Customer customer;
    private Store store;
    private LocalDate deliveryDate;

    public Order(String nameProduct, Integer quantityProduct, Customer customer, Store store, LocalDate deliveryDate) {
        this.nameProduct = nameProduct;
        this.quantityProduct = quantityProduct;
        this.customer = customer;
        this.store = store;
        this.deliveryDate = deliveryDate;
    }

}
