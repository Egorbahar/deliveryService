package com.exposit.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Integer quantity;
    private Store store;
    private List<Category> categories;
    private Double price;

    public Product(String name, Integer quantity, List<Category> categories, Double price, Store store) {
        this.name = name;
        this.quantity = quantity;
        this.categories = categories;
        this.price = price;
        this.store = store;
    }

    public Product(Long id) {
        this.id = id;
    }

    public String valueOfPrice() {
        return String.valueOf(price);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(quantity, product.quantity) &&
                Objects.equals(store, product.store) &&
                Objects.equals(categories, product.categories) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, store, categories, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", store=" + store.getId() +
                ", categories=" + categories +
                ", price=" + price +
                '}';
    }
}
