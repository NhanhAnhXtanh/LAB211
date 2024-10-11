/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validations;

import java.util.Scanner;
import models.Fruit;
import models.Order;
import service.ListFruit;
import service.ListOrder;

public class validation {

    final static Scanner sc = new Scanner(System.in);

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Enter a number (Integer): ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }
            System.err.print("Enter again (String): ");
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Enter a number (Double): ");
            }
        }
    }

    public static int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    System.err.print("Enter a number in range [" + min + "," + max + "]: ");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Enter a number in range [" + min + "," + max + "]: ");
            }
        }
    }

    public static boolean checkInputYN() {
        System.out.print("Do you want to continue (Y/N)? ");
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y n/N ");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkItemExist(ListFruit listFruit, String id) {
        if (listFruit.getListFruit() == null) {
            return false;
        }
        for (Fruit fruit : listFruit.getListFruit()) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkItemExist(ListOrder listOrder, String id) {
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

}
