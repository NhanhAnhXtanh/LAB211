package util;

import java.util.Scanner;

public class Validation {

    final static Scanner sc = new Scanner(System.in);

    public static String getValidString(String input, String error, String format) {
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

    public static String getRank(String input, String error) {
        while (true) {
            System.out.print(input);
            String result = sc.nextLine().trim(); //Excellence, Good, Fair, Poor
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result.substring(0, 1).toUpperCase() + result.substring(1, result.length() - 1).toLowerCase();
            } else {
                System.err.println(error);
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

}
