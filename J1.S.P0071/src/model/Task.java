package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

    private int id;
    private String nameTask;
    private int typeTask;
    private Date date;
    private Double planFrom;
    private Double planTo;
    private String assignee;
    private String reviewer;

    public Task(int id, String nameTask, int typeTask, Date date, Double planFrom, Double planTo, String assignee, String reviewer) {
        this.id = id;
        this.nameTask = nameTask;
        this.typeTask = typeTask;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String getNameTaskByType() {
        switch (typeTask) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
        }
        return null;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = dateFormat.format(date);
        return String.format("%-8d%-15s%-15s%-15s%-10.1f%-15s%-15s", id, nameTask,
                getNameTaskByType(), formatedDate, planTo - planFrom, assignee, reviewer);
    }
}
