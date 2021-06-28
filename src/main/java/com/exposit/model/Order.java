package com.exposit.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Order order = (Order) object;
        return Objects.equals(id, order.id) &&
                Objects.equals(nameProduct, order.nameProduct) &&
                Objects.equals(quantityProduct, order.quantityProduct) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(store, order.store) &&
                Objects.equals(deliveryDate, order.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nameProduct, quantityProduct, customer, store, deliveryDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", quantityProduct=" + quantityProduct +
                ", customer=" + customer +
                ", store=" + store.getName() +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
