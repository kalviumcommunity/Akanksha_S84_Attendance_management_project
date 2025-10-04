package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

  // Helper method to demonstrate polymorphism with Person objects
  public static void displaySchoolDirectory(List<Person> people) {
    System.out.println("\n--- School Directory ---");
    if (people.isEmpty()) {
      System.out.println("No people in the directory.");
      return;
    }
    for (Person person : people) {
      person.displayDetails(); // Polymorphic call
    }
  }

  public static void main(String[] args) {
    System.out.println("--- School Administration & Attendance System (Polymorphism Demo) ---");

    // --- Data Setup ---
    // Note: IDs (e.g., 1000, 1001, etc.) are automatically assigned in the
    // constructors
    Student student1 = new Student("Alice Wonderland", "Grade 10");
    Student student2 = new Student("Bob The Builder", "Grade 9");
    Teacher teacher1 = new Teacher("Dr. Emily Carter", "Physics");
    Staff staff1 = new Staff("Mr. John Davis", "Librarian");

    List<Person> schoolPeople = new ArrayList<>();
    schoolPeople.add(student1);
    schoolPeople.add(student2);
    schoolPeople.add(teacher1);
    schoolPeople.add(staff1);

    // Demonstrate polymorphic call through a helper method
    displaySchoolDirectory(schoolPeople);

    // --- Course Setup ---
    // Note: IDs (e.g., C100, C101) are automatically assigned in the constructors
    Course course1 = new Course("Intro to Quantum Physics");
    Course course2 = new Course("Advanced Algorithms");
    List<Course> courses = new ArrayList<>();
    courses.add(course1);
    courses.add(course2);

    System.out.println("\n\n--- Available Courses ---");
    for (Course c : courses)
      c.displayDetails();

    // --- Attendance Recording (Using Student and Course objects) ---
    List<AttendanceRecord> attendanceLog = new ArrayList<>();
    attendanceLog.add(new AttendanceRecord(student1, course1, "Present"));
    attendanceLog.add(new AttendanceRecord(student2, course1, "Absent"));
    // This will trigger the "Invalid" status warning from the AttendanceRecord
    // class
    attendanceLog.add(new AttendanceRecord(student1, course2, "Daydreaming"));

    System.out.println("\n\n--- Attendance Log ---");
    if (attendanceLog.isEmpty()) {
      System.out.println("No attendance records yet.");
    } else {
      for (AttendanceRecord ar : attendanceLog) {
        ar.displayRecord(); // displayRecord now uses Student/Course objects
      }
    }

    // --- Saving Data (Storable interface still uses IDs for simplicity) ---
    System.out.println("\n\n--- Saving Data to Files ---");
    FileStorageService storageService = new FileStorageService();

    // Filter and save only Student objects
    List<Student> studentsToSave = new ArrayList<>();
    for (Person p : schoolPeople) {
      if (p instanceof Student) {
        // Safe downcasting after 'instanceof' check
        studentsToSave.add((Student) p);
      }
    }

    if (!studentsToSave.isEmpty()) {
      // Students implement Storable, so they can be saved
      storageService.saveData(studentsToSave, "students.txt");
    } else {
      System.out.println("No student data to save from school directory.");
    }

    // Courses and AttendanceRecord also implement Storable
    storageService.saveData(courses, "courses.txt");
    storageService.saveData(attendanceLog, "attendance_log.txt");

    System.out.println("\nSession 7: Polymorphic Behaviour Demonstrated Complete.");
  }
}