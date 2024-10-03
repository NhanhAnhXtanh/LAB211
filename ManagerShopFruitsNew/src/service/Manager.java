package service;

import java.util.ArrayList;
import java.util.Hashtable;
import models.Fruit;
import models.Order;

public class Manager {
    
    private Hashtable<String, ListOrder> listCustomer = new Hashtable<>();

    public void createCustomer(String name, ListOrder order) {
        listCustomer.put(name, order);
    }

    public boolean isEmpty() {
        if (listCustomer.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }
        String result = "";
        for (String name : listCustomer.keySet()) {
            ListOrder listOrder = listCustomer.get(name);
            result += name + "\n" + listOrder.toString() +"\n";
        }
        return result;
    }
}
