/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class validation {

    final static Scanner sc = new Scanner(System.in);

    public static String getFormatString(String input, String error, String format) {
        while (true) {
            System.out.print(input);
            String string = sc.nextLine().trim();
            boolean match = string.matches(format);
            if (string.isEmpty() || !match) {
                System.err.println(error);
            } else {
                return string;
            }
        }
    }

    public static String getString(String input, String error) {
        while (true) {
            System.out.print(input);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println(error);
                continue;
            }
            return result;
        }
    }

    public static int getAnIntegerLimit(String input, String error, int min, int max) {
        while (true) {
            try {
                System.out.print(input);
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.err.println(error + "[" + min + "," + max + "]");
            }
        }
    }

    public static boolean getYN(String input, String error) {
        while (true) {
            System.out.print(input);
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println(error);
        }
    }

    public static double getDouble(String input, String error, double min, double max) {
        while (true) {
            try {
                System.out.print(input);
                double result = Double.parseDouble(sc.nextLine());
                if ((result >= min && result <= max) && ((int) (result * 10) % 10 == 0 || (int) (result * 10) % 10 == 5)) {
                    return result;
                }
                System.err.println(error + "[" + min + "," + max + "]");
            } catch (Exception e) {
                System.err.println(error + "[" + min + "," + max + "]");
            }
        }
    }

    public static Date getDate(String inputMsg, String errorMsg) {
        while (true) {
            System.out.print(inputMsg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            try {
                return dateFormat.parse(sc.nextLine().trim());
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }

}
