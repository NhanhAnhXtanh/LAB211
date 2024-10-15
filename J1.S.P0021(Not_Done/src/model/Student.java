package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Student implements Comparable<Student> {

    private String studentId;
    private String studentName;
    private int semester;
    private ArrayList<String> course = new ArrayList<>();

    public Student() {
    }

    public Student(String studentId, String studentName, int semester, ArrayList<String> course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.semester = semester;
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void addCourse(String course) {
        this.course.add(course);
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ArrayList<String> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<String> course) {
        this.course = course;
    }
    // Bo
    public void removeCours(String course) {
        for (String string : this.course) {
            if (string.equalsIgnoreCase(course)) {
                this.course.remove(course);
            }
        }
    }
    
    //new\
    public void removeCourses(String course){
        for (int i = 0; i < this.course.size(); i++) {
            if(this.course.get(i).equalsIgnoreCase(course)){
                this.course.remove(i);
                break;
            }
        }
    }
    
    // removeCourse
    public void removeCourse(String course) {
    Iterator<String> iterator = this.course.iterator();
    while (iterator.hasNext()) {
        String currentCourse = iterator.next();
        if (currentCourse.equalsIgnoreCase(course)) {
            iterator.remove();
        }
    }
}

    @Override
    public String toString() {
        return String.format("%-15s %-20s %-15s %-15s\n",
                this.studentId, this.studentName, this.semester, prinCourse());
    }

    public String prinCourse() {
        String result = "";
        for (String string : course) {
            if (!result.contains(string)) {
                result += string.toUpperCase() + " ";
            }
        }
        return result;
    }

    @Override
    public int compareTo(Student o) {
        return this.studentName.compareToIgnoreCase(o.getStudentName());
    }

}
