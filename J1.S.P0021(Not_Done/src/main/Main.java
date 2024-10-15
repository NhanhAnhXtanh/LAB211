package main;

import controller.ManagerStudent;
import java.util.ArrayList;
import ui.Menu;
import model.Student;
import util.Validation;

public class Main {

    public static void main(String[] args) {
        ManagerStudent manager = new ManagerStudent();
        Menu menu = new Menu();
        menu.addTitle("===== WELCOME TO STUDENT MANAGEMENT =====");
        menu.addOpion("1. Create");
        menu.addOpion("2. Find and Sort");
        menu.addOpion("3. Update/Delete");
        menu.addOpion("4. Report");
        menu.addOpion("5. Exit");
        int choice;
        while (true) {
            System.out.println(menu.toString());
            System.out.print("Enter an option: ");
            choice = Validation.checkInteger(1, menu.size());
            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    String id = Validation.checkID("H[AES]\\d{6}");
                    if (manager.checkStudentId(id)) {
                        System.err.println("ID exist");
                        break;
                    }
                    System.out.print("Enter name: ");
                    String name = Validation.checkString();
                    System.out.print("Enter semester: ");
                    int semester = Validation.checkInteger(1, 9);
                    ArrayList<String> course = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter course: ");
                        course.add(Validation.getCourse());
                        if (!Validation.checkYN("Do you want continue add course: ", "Enter again: ", "Y", "N")) {
                            break;
                        }
                    }
                    manager.createStudent(id, name, semester, course);
                    break;
                case 2:
                    if (manager.isEmpty()) {
                        System.err.println("No have student");
                        break;
                    }
                    System.out.print("Enter name need find: ");
                    String nameFound = Validation.checkString();
                    if (manager.searchStudentByName(nameFound) == null) {
                        System.err.println("No have student");
                        break;
                    }
                    ArrayList<Student> foundStudent = manager.searchStudentByName(nameFound);
                    for (Student student : foundStudent) {
                        System.out.print(student.toString());
                    }
                    break;
                case 3:
                    if (manager.isEmpty()) {
                        System.err.println("No have student");
                        break;
                    }

                    if (Validation.checkYN("Do you want Update(U) or Delete(D): ", "Enter again: ", "U", "D")) {
                        System.out.print("Enter id: ");
                        String idUpdate = Validation.checkID("H[AES]\\d{6}");
                        if (!manager.checkStudentId(idUpdate)) {
                            System.err.println("ID not exist");
                            break;
                        }
                        System.out.print("Enter course new: ");
                        String courseNew = Validation.checkString();
                        System.out.print("Enter semester: ");
                        int semesterNew = Validation.checkInteger(1, 9);
                        manager.updateStudentSemester(idUpdate, semesterNew);
                        manager.addStudentCourse(idUpdate, courseNew);
                        System.out.println("Update successfully");
                    } else {
                        System.out.print("Enter id: ");
                        String idDelete = Validation.checkID("H[AES]\\d{6}");
                        if (!manager.checkStudentId(idDelete)) {
                            System.err.println("ID not exist");
                            break;
                        }
                        Student studentDelete = manager.getStudent(idDelete);
                        manager.deleteStudent(studentDelete);
                        System.out.println("Delete Successfully");
                    }

                    break;
                case 4:
                    if (manager.isEmpty()) {
                        System.err.println("No have student");
                        break;
                    }
                    System.out.print(manager.report());
                    break;
                case 5:
                    System.err.println("EXITED");
                    return;

            }
        }

    }
}
