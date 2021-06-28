package com.exposit.ui.action.product;

import com.exposit.api.dao.ProductDao;
import com.exposit.api.dao.StoreDao;
import com.exposit.api.service.ProductService;
import com.exposit.api.service.StoreService;
import com.exposit.dao.ProductDaoImpl;
import com.exposit.dao.StoreDaoImpl;
import com.exposit.service.ProductServiceImpl;
import com.exposit.service.StoreServiceImpl;
import com.exposit.ui.action.Action;

public abstract class AbstractProductAction implements Action {
    protected static final StoreDao storeDao = new StoreDaoImpl();
    protected static final StoreService storeService = new StoreServiceImpl(storeDao);
    protected static final ProductDao productDao = new ProductDaoImpl();
    protected static final ProductService productService = new ProductServiceImpl(productDao);
}
