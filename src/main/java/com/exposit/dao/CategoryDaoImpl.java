package com.exposit.dao;

import com.exposit.api.dao.CategoryDao;
import com.exposit.model.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private final static String FILE_PATH = "/src/main/java/com/exposit/dao/json/Categories.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void save(Category category) {
        List<Category> categories = getAll();
        categories.add(category);
        writeFile(categories);
    }

    public List<Category> getAll() {
        BufferedReader bufferedReader = null;
        try {
            String absolutePath = new File("").getAbsolutePath();
            bufferedReader = new BufferedReader(new FileReader(absolutePath + FILE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type type = new TypeToken<List<Category>>() {
        }.getType();
        List<Category> categories = gson.fromJson(bufferedReader, type);
        return categories;
    }

    public void writeFile(List<Category> list) {
        String absolutePath = new File("").getAbsolutePath();
        try (FileWriter writer = new FileWriter(absolutePath + FILE_PATH)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
