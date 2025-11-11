School Attendance System
This is a 10-part code-along project to build a console-based school attendance system in Java.

## Session 1: Introduction and Orientation

- Verified Java and Git setup.
- Initialized Git repository for the project.
- Created basic project structure with `Main.java`.
- Compiled and ran the initial "Welcome" program.
- Pushed initial setup to a `part-01` branch on GitHub and created a PR.

### How to Run

1. Navigate to the project root directory (`AttendanceSystem`).
2. Compile: `javac src/com/school/Main.java`
3. Run: `java -cp src com.school.Main`

## Part 3: Constructor Initialization & Auto-ID Generation

- Implemented parameterized constructors in `Student` and `Course` classes for object initialization.
- Utilized `private static` member variables for automatic and unique ID generation.
- Demonstrated the use of the `this` keyword to distinguish instance variables from constructor parameters.
- Changed `Course`'s `courseId` to `int` for simpler auto-generation and updated its display.
- Updated `Main.java` to use constructors and show ID progression.

## Part 10: Capacity Management & SOLID Principles Reflection

- Added a `capacity` feature to the `Course` class, along with an internal list of `enrolledStudents`.
- Updated `Course.displayDetails()` to show capacity and enrollment count, and `Course.toDataString()` to save capacity.
- Modified `RegistrationService`:
  - `createCourse` method now accepts a capacity parameter.
  - Added `enrollStudentInCourse(Student student, Course course)` method to handle enrollment logic, checking against course capacity.
- Updated `Main.java` to demonstrate course creation with capacity, student enrollment attempts (including exceeding capacity), and displaying updated course information.
- Discussed how other SOLID principles (like Open-Closed and Dependency Inversion) could be applied for further enhancements and flexibility.
- Concluded the 10-part project, having built a foundational console-based attendance system.

### How to Run

1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check `courses.txt` for the capacity field and other files for their respective data.
