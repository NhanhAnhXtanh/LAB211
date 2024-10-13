package controller;

import java.util.Hashtable;

public class Manager {

    private final Hashtable<String, ListOrder> listCustomer = new Hashtable<>();

    public void createCustomer(String name, ListOrder order) {
        listCustomer.put(name, order);
    }

    public boolean isEmpty() {
        return listCustomer.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }
        String result = "";
        for (String name : listCustomer.keySet()) {
            ListOrder listOrder = listCustomer.get(name);
            result += name + "\n" + listOrder.toString() + "\n";
        }
        return result;
    }
}
