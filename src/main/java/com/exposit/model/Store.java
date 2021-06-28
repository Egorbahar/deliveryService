package com.exposit.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Store {
    private Long id;
    private String name;
    private String address;
    private List<Product> products;

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
        this.products = new ArrayList<>();
    }

    public Store(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Store store = (Store) object;
        return Objects.equals(id, store.id) &&
                Objects.equals(name, store.name) &&
                Objects.equals(address, store.address) &&
                Objects.equals(products, store.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, products);
    }
}
