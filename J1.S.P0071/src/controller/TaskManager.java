package controller;

import java.util.ArrayList;
import model.Task;

public class TaskManager {

    private final ArrayList<Task> taskList = new ArrayList<>();

    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    public int size() {
        return taskList.size();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void delTask(int id) {
        taskList.remove(id - 1);
        for (int i = id - 1; i < taskList.size(); i++) {
            taskList.get(i).setId(i + 1);
        }
    }

    public  String displayTask() {
        StringBuilder result = new StringBuilder();
        for (Task task : taskList) {
            result.append(task.toString() + "\n");
        }
        return result.toString();
    }

}
