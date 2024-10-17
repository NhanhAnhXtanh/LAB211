/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Task;

/**
 *
 * @author Admin
 */
public class TaskList {

    private ArrayList<Task> taskList = new ArrayList<>();

    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    public int size() {
        return taskList.size();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(int id) {
        taskList.remove(id - 1);
        for (int i = id - 1; i < taskList.size(); i++) {
            taskList.get(i).setId(i + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Task task : taskList) {
            result.append(task.toString() + "\n");
        }
        return result.toString();
    }
}
