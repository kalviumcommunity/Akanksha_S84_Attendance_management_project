package com.school;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Storable {
    private List<String> attendance = new ArrayList<>();
    private String grade;

    public Student(String name) {
        super(name);
    }

    // Overloaded constructor to accept grade (used by Main)
    public Student(String name, String grade) {
        super(name);
        this.grade = grade;
    }

    public void recordAttendance(String date, boolean present) {
        attendance.add(date + ": " + (present ? "Present" : "Absent"));
    }

    public List<String> getAttendance() {
        return new ArrayList<>(attendance);
    }

    @Override
    public void displayDetails() {
        System.out.print("Student ID: " + this.id + ", Name: " + this.name);
        if (grade != null) {
            System.out.print(", Grade: " + grade);
        }
        System.out.println();
    }

    @Override
    public String toDataString() {
        // Format: id,name,grade
        return id + "," + name + "," + (grade == null ? "" : grade);
    }
}