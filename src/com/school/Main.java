package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("--- School Administration & Attendance System ---");

    // --- Data Setup ---
    // Note: Make sure you have a Student class that implements Storable
    // and has a getId() method.
    List<Student> students = new ArrayList<>();
    students.add(new Student("Alice Wonderland", "Grade 10"));
    students.add(new Student("Bob The Builder", "Grade 9"));

    List<Course> courses = new ArrayList<>();
    courses.add(new Course("Intro to Quantum Physics"));
    courses.add(new Course("Advanced Algorithms"));

    List<AttendanceRecord> attendanceLog = new ArrayList<>();
    // For accurate IDs, we get them from the objects
    attendanceLog.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
    attendanceLog.add(new AttendanceRecord(students.get(1).getId(), courses.get(0).getCourseId(), "Absent"));
    attendanceLog.add(new AttendanceRecord(students.get(0).getId(), courses.get(1).getCourseId(), "Present"));

    System.out.println("\n--- School Personnel & Course Details ---");
    System.out.println("Students:");
    for (Student s : students)
      s.displayDetails();
    System.out.println("\nCourses:");
    for (Course c : courses)
      c.displayDetails();
    System.out.println("\nAttendance Log (Initial):");
    for (AttendanceRecord ar : attendanceLog)
      ar.displayRecord();

    // --- Saving Data ---
    System.out.println("\n--- Saving Data to Files ---");
    FileStorageService storageService = new FileStorageService();

    storageService.saveData(students, "students.txt");
    storageService.saveData(courses, "courses.txt");
    storageService.saveData(attendanceLog, "attendance_log.txt");

    System.out.println("\nSession 6: Interface-Driven Persistence (Saving) Complete.");
    System.out.println("Check students.txt, courses.txt, and attendance_log.txt for output.");
  }
}