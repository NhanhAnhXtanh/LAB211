package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Student;

public class ManagerStudent {

    private ArrayList<Student> studentList = new ArrayList();

    public ManagerStudent() {
    }

    public ManagerStudent(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public boolean isEmpty() {
        return studentList.isEmpty();
    }

    // create Student
    public void createStudent(String id, String name, int semester, ArrayList<String> courseName) {
        studentList.add(new Student(id, name, semester, courseName));
    }

    //find and sort
    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> foundStudent = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getStudentName().toUpperCase().contains(name.toUpperCase())) {
                foundStudent.add(student);
            }
        }
        if (!foundStudent.isEmpty()) {
            return sortStudentByName(foundStudent);
        }
        return null;
    }

    public ArrayList<Student> sortStudentByName(ArrayList<Student> foundStudent) {
        Collections.sort(foundStudent);
        return foundStudent;
    }

    public boolean checkStudentId(String id) {
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    //update name
    public void updateStudentName(String id, String Name) {
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(id)) {
                student.setStudentName(Name);
                return;
            }
        }
    }

    //Semester
    public void updateStudentSemester(String id, int Semester) {
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(id)) {
                student.setSemester(Semester);
                return;
            }
        }
    }

    //course (add || delete)
    public void addStudentCourse(String id, String Course) {
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(id)) {
                student.addCourse(Course);
                return;
            }
        }
    }


    
    public void deleteStudentCourse(String id, String Course) {
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(id)) {
                student.removeCourse(Course);
                return;
            }
        }
    }

    //find student and delete
    public void deleteStudent(Student studentDelete) {
        studentList.remove(studentDelete);
    }

    public Student getStudent(String id) {
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public String report() {
        String result = "";
        for (Student student : studentList) {
            HashMap<String, Integer> countCourse = new HashMap<>();
            for (String course : student.getCourse()) {
                countCourse.put(student.prinCourse(), countCourse.getOrDefault(student.prinCourse(), 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : countCourse.entrySet()) {
                result += String.format("%-20s|%-15s|%-10s\n", student.getStudentName(), 
                        entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
