package com.exposit.dao;

import com.exposit.api.dao.OrderDao;
import com.exposit.model.Order;
import com.exposit.model.Store;
import com.exposit.util.PropertyReader;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().setExclusionStrategies(new OrderDaoImpl.ExclusionForOrder()).create();

    @Override
    public void save(Order order) {
        if (order.getId() == null) {
            order.setId((long) (Math.random() * 100));
        }
        List<Order> orders = getAll();
        orders.add(order);
        writeFile(orders);
    }

    @Override
    public Order getById(Long id) {
        return getAll().stream()
                       .filter(order -> order.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders;
        BufferedReader bufferedReader = null;
        try {
            String absolutePath = new File("").getAbsolutePath();
            bufferedReader = new BufferedReader(new FileReader(absolutePath + new PropertyReader().getPropertyValue("ORDER_FILE")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type type = new TypeToken<List<Order>>() {
        }.getType();
        orders = gson.fromJson(bufferedReader, type);
        return orders;
    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public void delete(Long id) {
        List<Order> orders = getAll();
        Order deleteOrder = orders.stream()
                                  .filter(p -> p.getCustomer().getId().equals(id))
                                  .findFirst()
                                  .get();
        orders.remove(deleteOrder);
        writeFile(orders);
    }

    public void writeFile(List<Order> list) {
        String absolutePath = new File("").getAbsolutePath();
        try (FileWriter writer = new FileWriter(absolutePath + new PropertyReader().getPropertyValue("ORDER_FILE"))) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ExclusionForOrder implements ExclusionStrategy {
        @Override
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return (fieldAttributes.getDeclaringClass() == Store.class && fieldAttributes.getName().equals("address"))
                    || (fieldAttributes.getDeclaringClass() == Store.class && fieldAttributes.getName().equals("products"));
        }

        @Override
        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    }
}
