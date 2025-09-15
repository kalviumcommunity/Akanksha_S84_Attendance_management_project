package com.school;

import java.util.List;
import java.util.ArrayList;

// Main.java

public class Main {
  public static void main(String[] args) {
    System.out.println("--- School Management System ---");

    // Create instances of Student, Teacher, and Staff
    Student student1 = new Student("Alice", "10th Grade");
    Teacher teacher1 = new Teacher("Mr. Smith", "Mathematics");
    Staff staff1 = new Staff("Mr. Davis", "Librarian");

    System.out.println("\nDisplaying Details:");
    System.out.println("--------------------");

    // Display details for each person
    student1.displayDetails();
    System.out.println(); // for spacing
    teacher1.displayDetails();
    System.out.println(); // for spacing
    staff1.displayDetails();
    System.out.println("--------------------");

    // Example of using getId() for attendance
    // Assuming an AttendanceRecord class or similar logic exists
    System.out.println("\nRecording Attendance for Student ID: " + student1.getId());
    student1.recordAttendance("2025-09-15", true);
    System.out.println("Attendance for " + student1.getName() + ": " + student1.getAttendance());
  }
}