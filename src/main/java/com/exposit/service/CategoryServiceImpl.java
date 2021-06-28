package com.exposit.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.service.CategoryService;
import com.exposit.model.Category;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }
}
