package service;

import java.util.ArrayList;
import models.Fruit;
import models.Fruit;

public class ListFruit {

    private ArrayList<Fruit> listFruit = new ArrayList<>();

    ;

    public ListFruit() {
    }

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }

    public void setListFruit(ArrayList<Fruit> listFruit) {
        this.listFruit = listFruit;
    }

    public boolean isEmpty() {
        if (listFruit.isEmpty()) {
            return true;
        }
        return false;
    }

    public Fruit getFruitById(String ID) {
        if (isEmpty()) {
            return null;
        }
        for (Fruit fruit : listFruit) {
            if (fruit.getFruitId().equalsIgnoreCase(ID)) {
                return fruit;
            }
        }
        return null;
    }

    public Fruit getFruitByItem(int item) {
        int countItem = 1;
        for (Fruit fruit : listFruit) {
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public void createFruit(String fruitID, String fruitName, double fruitPrice,
            int fruitQuantity, String fruitOrigin) {
        listFruit.add(new Fruit(fruitID, fruitName, fruitPrice,
                fruitQuantity, fruitOrigin));
    }

    public void setQuantity(String Id, int quantityNew) {
        if (isEmpty()) {
            return;
        }
        for (Fruit fruit : listFruit) {
            if (fruit.getFruitId().equalsIgnoreCase(Id)) {
                fruit.setQuantity(quantityNew);
                return;
            }
        }

    }

    public void remove(String ID) {
        if (isEmpty()) {
            return;
        }
        for (Fruit fruit : listFruit) {
            if (fruit.getFruitId().equalsIgnoreCase(ID)) {
                listFruit.remove(getFruitById(ID));
                return;
            }
        }
    }

    public int getSize() {
        int cnt = 0;
        for (Fruit fruit : listFruit) {
            cnt++;
        }
        return cnt;
    }

    @Override
    public String toString() {
        String result = String.format("%-13s%-15s%-13s%-10s\n", "Item", "Name", "Origin", "Price");
        int itemCount = 1;
        for (Fruit fruit : listFruit) {
            String item = String.format("%-13s", itemCount++);
            result += item + fruit.toString();
        }
        return result;
    }

}
