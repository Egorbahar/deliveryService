package com.exposit.ui.action.store;

import com.exposit.api.dao.StoreDao;
import com.exposit.api.service.StoreService;
import com.exposit.dao.StoreDaoImpl;
import com.exposit.service.StoreServiceImpl;
import com.exposit.ui.action.Action;

public abstract class AbstractStoreAction implements Action {
    protected static final StoreDao storeDao = new StoreDaoImpl();
    protected static final StoreService storeService = new StoreServiceImpl(storeDao);
}
