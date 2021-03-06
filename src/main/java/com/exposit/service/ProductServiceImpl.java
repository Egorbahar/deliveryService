package com.exposit.service;

import com.exposit.api.dao.ProductDao;
import com.exposit.api.service.ProductService;
import com.exposit.enums.CategoryItem;
import com.exposit.model.Category;
import com.exposit.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product addProduct(Product product) {
        return productDao.save(product);
    }

    public Product deleteProduct(Product product) {
        return productDao.delete(product);
    }

    @Override
    public void updateProduct(Product productUp) {
        productDao.update(productUp);
    }

    @Override
    public List<Product> findByAttributes(Map<Integer, String> attributes) {
        return productDao.getAll()
                         .stream()
                         .filter(p -> filterIfContainsAttribute(attributes, 1, Product::getName).test(p))
                         .filter(p -> filterIfContainsAttribute(attributes, 2, Product::valueOfPrice).test(p))
                         .filter(p -> filterIfContainsAttribute(attributes, 3, pr -> pr.getStore().getName()).test(p))
                         .collect(Collectors.toList());
    }

    private Predicate<Product> filterIfContainsAttribute(Map<Integer, String> attributes, Integer attributeIndex, Function<Product, String> f) {
        return object -> !attributes.containsKey(attributeIndex) || f.apply(object).equals(attributes.get(attributeIndex));
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productDao.getAll().stream()
                         .filter(product -> product.getCategories().contains(category))
                         .collect(Collectors.toList());
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> getAllByStoreId(Long storeId) {
        return productDao.getAllByStoreId(storeId);
    }

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public void deleteProductByStoreId(Long storeId) {
        productDao.deleteAllByStoreId(storeId);
    }

    @Override
    public List<Product> findByCategories(List<Integer> categories) {
        return productDao.getAll().stream()
                         .filter(product -> product.getCategories()
                                                   .stream()
                                                   .map(Category::getCategoryItem)
                                                   .map(CategoryItem::getIndex)
                                                   .collect(Collectors.toList())
                                                   .containsAll(categories))
                         .collect(Collectors.toList());
    }

    public List<Product> sortByPrice(Long storeId) {
        return productDao.getAll().stream()
                         .filter(product -> product.getStore().getId().equals(storeId))
                         .sorted(Comparator.comparing(Product::getPrice))
                         .collect(Collectors.toList());
    }
}
