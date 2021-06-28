package com.exposit.model;

import com.exposit.enums.CategoryItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Category {
    CategoryItem categoryItem;
    Long productId;

    public Category(CategoryItem categoryItem) {
        this.categoryItem = categoryItem;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Category category = (Category) object;
        return categoryItem == category.categoryItem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryItem);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryItem=" + categoryItem +
                '}';
    }
}
