/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Task {

    private int id;
    private String typeTask;
    private String nameTask;
    private Date date;
    private double from;
    private double to;
    private String assignee;
    private String review;

    public Task(int id, String typeTask, String nameTask, Date date, double from, double to, String assignee, String review) {
        this.id = id;
        this.typeTask = typeTask;
        this.nameTask = nameTask;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.review = review;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = dateFormat.format(date);
        return String.format("%-8d%-15s%-15s%-15s%-8.1f%-15s%-15s", id, typeTask, nameTask, formatedDate, to - from, assignee, review);
    }

}
