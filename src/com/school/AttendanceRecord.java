package com.school;

// NOTE: We assume Student and Course classes exist and have getId()/getCourseId(), 
// and the Storable interface has been defined.

public class AttendanceRecord implements Storable {
  private Student student;
  private Course course;
  private String status;

  // Assuming a mechanism to load Student and Course objects exists (e.g., from a
  // Repository)
  // This interface/method is illustrative of what would be needed for
  // fromDataString.
  public interface DataRepository {
    Student getStudentById(int studentId);

    Course getCourseById(int courseId);
  }

  // --- Constructors ---

  public AttendanceRecord(Student student, Course course, String status) {
    this.student = student;
    this.course = course;
    setStatus(status); // Use the setter for status validation
  }

  // Private constructor for use with a static factory method (like
  // fromDataString)
  // This allows creating an AttendanceRecord with already validated data
  private AttendanceRecord(Student student, Course course, String status, boolean skipValidation) {
    this.student = student;
    this.course = course;
    this.status = status;
  }

  // --- Getters ---

  public Student getStudent() {
    return student;
  }

  public Course getCourse() {
    return course;
  }

  public String getStatus() {
    return status;
  }

  // --- Setter (for potential updates) ---

  // Added a setter to update the status with validation
  public void setStatus(String newStatus) {
    if (newStatus != null && ("Present".equalsIgnoreCase(newStatus) || "Absent".equalsIgnoreCase(newStatus))) {
      this.status = newStatus;
    } else {
      this.status = "Invalid";
      // Print a warning if the status is set to 'Invalid'
      if (newStatus != null && !newStatus.equalsIgnoreCase("Invalid")) {
        System.out
            .println("Warning: Invalid attendance status provided ('" + newStatus + "'). Status set to 'Invalid'.");
      }
    }
  }

  // --- Utility Methods ---

  public void displayRecord() {
    // Added checks to prevent NullPointerException if student or course are somehow
    // null
    String studentDetails = (student != null) ? student.getName() + " (ID: " + student.getId() + ")"
        : "Unknown Student";
    String courseDetails = (course != null) ? course.getCourseName() + " (ID: C" + course.getCourseId() + ")"
        : "Unknown Course";

    System.out.println("Attendance: Student " + studentDetails +
        " in Course " + courseDetails +
        " - Status: " + status);
  }

  // --- Storable Interface Implementations ---

  @Override
  public String toDataString() {
    // Uses IDs for simplicity in file storage, as originally intended.
    // Assuming getId() and getCourseId() return int and won't be null.
    return student.getId() + "," + course.getCourseId() + "," + status;
  }

  // ⭐ CRITICAL FIX/ADDITION: Implementation to reload the object from a String.
  // NOTE: This implementation is dependent on a 'DataRepository' mechanism
  // to look up the Student and Course objects based on their IDs.
  public static AttendanceRecord fromDataString(String dataString, DataRepository repository) {
    String[] parts = dataString.split(",");
    if (parts.length != 3) {
      throw new IllegalArgumentException("Invalid data string format for AttendanceRecord: " + dataString);
    }

    try {
      int studentId = Integer.parseInt(parts[0]);
      int courseId = Integer.parseInt(parts[1]);
      String status = parts[2];

      // Look up the objects using the repository
      Student student = repository.getStudentById(studentId);
      Course course = repository.getCourseById(courseId);

      if (student == null || course == null) {
        // Handle cases where IDs exist but objects can't be found (e.g., deleted)
        throw new IllegalStateException(
            "Could not find Student (ID: " + studentId + ") or Course (ID: " + courseId + ")");
      }

      // Use the private constructor to bypass redundant status validation on reload
      return new AttendanceRecord(student, course, status, true);

    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Non-integer ID found in data string: " + dataString, e);
    }
  }
}