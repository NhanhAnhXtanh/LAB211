package util;

import java.util.Scanner;

public class Validation {

    final static Scanner sc = new Scanner(System.in);

    public static boolean checkYN(String input, String error, String yesOrUpdate, String noOrDelete) {
        System.out.print(input); //
        while (true) {
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase(yesOrUpdate)) {
                return true;
            } else if (result.equalsIgnoreCase(noOrDelete)) {
                return false;
            }
            System.out.print(error);
        }
    }

    public static int checkInteger(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.out.print("Enter again a number [" + min + "," + max + "]: ");
            }
        }
    }

    public static String checkString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                continue;
            }
            return result;
        }
    }

    public static String checkID(String format) {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.matches(format)) {
                return result;
            }
            System.out.print("Enter again ID [HEXXXXXX, HAXXXXXX, HSXXXXXX]: ");
        }
    }

    public static String getCourse() {
        while (true) {
            System.out.print("Enter course: ");
            String course = checkString();
            if (course.equalsIgnoreCase("java")
                    || course.equalsIgnoreCase(".net")
                    || course.equalsIgnoreCase("c/c++")) {
                return course.toUpperCase();
            } else {
                System.err.println("There are only three courses: Java, .Net, C/C++");
            }
        }
    }
}
