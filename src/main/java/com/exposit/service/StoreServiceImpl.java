package com.exposit.service;

import com.exposit.api.dao.StoreDao;
import com.exposit.api.service.StoreService;
import com.exposit.model.Store;

import java.io.IOException;
import java.util.List;

public class StoreServiceImpl implements StoreService {
    private final StoreDao storeDao;

    public StoreServiceImpl(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public void add(Store store) throws IOException {
        storeDao.save(store);
    }

    @Override
    public void deleteStore(Long id) {
        storeDao.delete(id);
    }

    @Override
    public void updateStore(Store store) {
        storeDao.update(store);
    }

    public List<Store> getAll() {
        return storeDao.getAll();
    }

    @Override
    public Store getById(Long id) {
        return storeDao.getById(id);
    }
}
