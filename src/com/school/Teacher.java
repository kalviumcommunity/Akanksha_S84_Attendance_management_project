package com.school;

public class Teacher extends Person {
  private String subjectTaught;

  public Teacher(String name, String subjectTaught) {
    super(name); // Calls the Person class constructor
    this.subjectTaught = subjectTaught;
  }

  public String getSubjectTaught() {
    return subjectTaught;
  }

  // Override the displayDetails method
  @Override
  public void displayDetails() {
    super.displayDetails(); // Calls the displayDetails method from Person
    System.out.println("Role: Teacher, Subject: " + subjectTaught);
  }
}
