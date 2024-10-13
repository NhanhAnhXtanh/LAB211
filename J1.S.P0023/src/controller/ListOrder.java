package controller;

import java.util.ArrayList;
import models.Order;

public class ListOrder {

    private ArrayList<Order> listOrder = new ArrayList<>();

    public ListOrder() {
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(ArrayList<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public boolean isEmpty() {
        return listOrder.isEmpty();
    }

    public Order getFruitById(String ID) {
        if (isEmpty()) {
            return null;
        }
        for (Order order : listOrder) {
            if (order.getFruitId().equalsIgnoreCase(ID)) {
                return order;
            }
        }
        return null;
    }

    public void createOrder(String fruitId, String fruitName, int fruitQuantity, double fruitPrice) {
        listOrder.add(new Order(fruitId, fruitName, fruitQuantity, fruitPrice));
    }

    public void setQuantity(String Id, int quantity) {
        if (isEmpty()) {
            return;
        }
        for (Order order : listOrder) {
            if (order.getFruitId().equalsIgnoreCase(Id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

    public String amountOrder() {
        double amount = 0;
        for (Order order : listOrder) {
            amount += order.getPrice() * order.getQuantity();
        }
        return String.format("Total: %d$", (int) amount);
    }

    public boolean checkItemExist(ListOrder listOrder, String id) {
        if (listOrder.getListOrder() == null) {
            return false;
        }
        for (Order order : listOrder.getListOrder()) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (listOrder.isEmpty()) {
            return null;
        }
        int countItem = 1;
        String result = String.format("%-14s%-14s%-12s%-10s\n", "Product", "Quantity", " Price", "Amount");
        for (Order order : listOrder) {
            result += String.format("%-2s", countItem++) + order.toString();
        }
        return result + amountOrder();
    }
}
