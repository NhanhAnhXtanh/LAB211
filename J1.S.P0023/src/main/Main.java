package main;

import util.Validation;
import controller.Manager;
import models.Fruit;
import ui.Menu;
import controller.ListFruit;
import controller.ListOrder;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        ListFruit listFruit = new ListFruit();
        Menu menu = new Menu();
        menu.addTitleMenu("CANDIDATE MANAGEMENT SYSTEM");
        menu.addOptionMenu("1. Create Fruit");
        menu.addOptionMenu("2. View orders");
        menu.addOptionMenu("3. Shopping (for buyer)");
        menu.addOptionMenu("4. Exit");
        int choice;
        while (true) {
            System.out.print(menu.toString());
            choice = menu.getchoice(1, 4);
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Enter Fruit ID: ");
                        String fruitID = Validation.checkInputString();
                        if (listFruit.checkItemExist(listFruit, fruitID)) {
                            System.err.println("Existed");
                            break;
                        }
                        System.out.print("Enter name: ");
                        String fruitName = Validation.checkInputString();
                        System.out.print("Enter price: ");
                        double fruitPrice = Validation.checkInputDouble();
                        System.out.print("Enter quantity: ");
                        int fruitQuantity = Validation.checkInputInt();
                        System.out.print("Enter origin: ");
                        String fruitOrigin = Validation.checkInputString();
                        listFruit.createFruit(fruitID, fruitName, fruitPrice, fruitQuantity, fruitOrigin);
                        if (!Validation.checkInputYN()) {
                            System.err.println("Add Suscessfull");
                            break;
                        }
                    }
                    break;
                case 2:
                    if (manager.isEmpty()) {
                        System.err.println("No have customer");
                        break;
                    }
                    System.out.print(manager.toString());
                    break;
                case 3:
                    if (listFruit.getListFruit().isEmpty()) {
                        System.err.println("No have Item");
                        break;
                    }
                    ListOrder lo = new ListOrder();
                    while (true) {
                        if (listFruit.getListFruit().isEmpty()) {
                            System.err.println("No have Item");
                            break;
                        }
                        System.out.print(listFruit.toString());
                        System.out.print("Enter item: ");
                        int itemOfBuyer = Validation.checkInputLimit(1, listFruit.getSize());
                        System.out.print("Enter quantity: ");
                        Fruit fruit = listFruit.getFruitByItem(itemOfBuyer);
                        int quantityBuyer = Validation.checkInputLimit(1, fruit.getQuantity());
                        int fruitQuantityNew = fruit.getQuantity() - quantityBuyer;
                        if (fruitQuantityNew <= 0) {
                            listFruit.remove(fruit.getFruitId());
                        } else {
                            listFruit.setQuantity(fruit.getFruitId(), fruitQuantityNew);
                        }

                        if (lo.checkItemExist(lo, fruit.getFruitId())) {
                            lo.setQuantity(fruit.getFruitId(), quantityBuyer);
                        } else {
                            lo.createOrder(fruit.getFruitId(), fruit.getFruitName(),
                                    quantityBuyer, fruit.getPrice());
                        }

                        if (!Validation.checkInputYN()) {
                            break;
                        }
                    }
                    System.out.println(lo.toString());
                    System.out.print("Enter name: ");
                    String name = Validation.checkInputString();
                    manager.createCustomer(name, lo);
                    break;
                case 4:
                    System.out.println("Exited");
                    return;

            }
        }
    }

}
