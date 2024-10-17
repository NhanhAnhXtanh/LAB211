package main;

import controller.TaskManager;
import java.util.Date;
import model.Task;
import ui.Menu;
import util.Validation;

public class Main {

    public static void main(String[] args) {
        TaskManager taskList = new TaskManager();
        Menu menu = new Menu();
        menu.addTitleMenu("========= Task program =========");
        menu.addOptionMenu("1. Add Task");
        menu.addOptionMenu("2. Delete task");
        menu.addOptionMenu("3. Display Task");
        menu.addOptionMenu("4. Exit");
        int choice;
        int id = 1;
        while (true) {
            System.out.print(menu.toString());
            choice = Validation.getAnIntegerLimit("Enter an option: ", "Enter again ",
                    1, menu.size());
            switch (choice) {
                case 1:
                    System.out.println("------------Add Task---------------");
                    String name = Validation.getString("Enter name task: ", "Enter again");
                    int type = Validation.getAnIntegerLimit("Enter type: ", "Enter again",
                            1, 4);
                    Date date = Validation.getDate("Enter date: ", "Enter again");
                    double planFrom = Validation.getDouble("Enter From: ", "Enter again", 8, 17.5);
                    double planTo = Validation.getDouble("Enter To: ", "Enter again", 8, 17.5);
                    String assignee = Validation.getString("Assignee: ", "Enter again");
                    String reviewer = Validation.getString("Reviewer: ", "Enter again");
                    taskList.addTask(new Task(id++, name, type, date, planFrom, planTo, assignee, reviewer));
                    System.err.println("Add successfully");
                    break;
                case 2:
                    System.out.println("------------Delete Task---------------");
                    if (taskList.isEmpty()) {
                        System.err.println("No have task");
                        break;
                    }
                    int idDel = Validation.getAnIntegerLimit("Enter ID:", "Enter again",
                            1, taskList.size());
                    taskList.delTask(idDel);
                    System.out.println("Delete successfully");
                    break;
                case 3:
                    System.out.println("-------------Task----------------");
                    if (taskList.isEmpty()) {
                        System.err.println("No have task");
                        break;
                    }
                    System.out.printf("%-8s%-15s%-15s%-15s%-10s%-15s%-15s\n", "ID", "Name",
                            "Task Type", "Date", "Time", "Assignee", "reviewer");
                    System.out.print(taskList.displayTask());
                    break;
                case 4:
                    System.out.println("EXITED");
                    return;
            }
        }
    }
}
