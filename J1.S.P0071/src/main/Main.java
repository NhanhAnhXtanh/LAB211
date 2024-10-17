/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.TaskList;
import dataEnum.TypeTask;
import java.util.Date;
import model.Task;
import ui.Menu;
import util.validation;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
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
            choice = validation.getAnIntegerLimit("Enter an option: ", "Enter again ", 1, menu.size());
            switch (choice) {
                case 1:
                    int typeTaskID = validation.getAnIntegerLimit("Enter type task: ", "Enter again ", 1, 4);
                    String nameTask = validation.getString("Enter name task: ", "Enter again");
                    String typeTask = "";
                    switch (typeTaskID) {
                        case 1:
                            typeTask = Enum.valueOf(TypeTask.class, "one").toString();
                            break;
                        case 2:
                            typeTask = Enum.valueOf(TypeTask.class, "two").toString();
                            break;
                        case 3:
                            typeTask = Enum.valueOf(TypeTask.class, "three").toString();
                            break;
                        case 4:
                            typeTask = Enum.valueOf(TypeTask.class, "four").toString();
                            break;
                    }
                    Date date = validation.getDate("Enter date: ", "Enter format [dd-MM-yyyy]");
                    double from = validation.getDouble("Enter plan from: ", "Enter in range 8 -> 17.5", 8, 17.5);
                    double to = validation.getDouble("Enter plan to: ", "Enter in range 8 -> 17.5", 8, 17.5);
                    String assignee = validation.getString("Enter assignee: ", "Enter again");
                    String review = validation.getString("Enter reviewer: ", "Enter again");
                    taskList.addTask(new Task(id++, typeTask, nameTask, date, from, to, assignee, review));
                    System.err.println("Add Successfully");
                    break;
                case 2:
                    if (taskList.isEmpty()) {
                        System.err.println("No have task");
                        break;
                    }
                    int idDelete = validation.getAnIntegerLimit("Enter id to delete: ", "Enter again ", 1, taskList.size());
                    taskList.deleteTask(idDelete); // sai 2 lan de y
                    id--;
                    System.err.println("Delete successfully");
                    break;
                case 3:
                    if (taskList.isEmpty()) {
                        System.err.println("No have task");
                        break;
                    }
                    System.out.printf("%-8s%-15s%-15s%-15s%-8s%-15s%-15s\n", "ID", "Task Type", "Name", "Date", "Time", "Assignee", "Review");
                    System.out.println(taskList.toString());
                    break;
                case 4:
                    System.out.println("EXITED");
                    return;
            }

        }
    }

}
