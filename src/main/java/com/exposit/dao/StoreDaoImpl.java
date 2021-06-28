package com.exposit.dao;

import com.exposit.api.dao.StoreDao;
import com.exposit.model.Store;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class StoreDaoImpl implements StoreDao {
    private final static String FILE_PATH = "/src/main/java/com/exposit/dao/json/Stores.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void save(Store store) {
        if (store.getId() == null) {
            store.setId((long) (Math.random() * 100));
        }
        List<Store> stores = getAll();
        stores.add(store);
        writeFile(stores);
    }

    public Store getById(Long id) {
        return getAll().stream()
                       .filter(s -> s.getId().equals(id)).findFirst().orElse(null);//написать exp
    }

    public List<Store> getAll() {
        List<Store> stores;
        BufferedReader bufferedReader = null;
        try {
            String absolutePath = new File("").getAbsolutePath();
            bufferedReader = new BufferedReader(new FileReader(absolutePath + FILE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type type = new TypeToken<List<Store>>() {
        }.getType();
        stores = gson.fromJson(bufferedReader, type);
        return stores;
    }

    public void delete(Long id) {
        List<Store> stores = getAll();
        Store deleteStore = stores.stream()
                                  .filter(s -> s.getId().equals(id))
                                  .findFirst()
                                  .get();
        stores.remove(deleteStore);
        writeFile(stores);
    }

    public Store update(Store storeUp) {
        Store store = getById(storeUp.getId());
        List<Store> updateList = getAll();
        updateList.set(updateList.indexOf(store), storeUp);
        writeFile(updateList);
        return store;
    }

    public void writeFile(List<Store> list) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
