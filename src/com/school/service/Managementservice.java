package com.school.service;
// importing the files from the other three classes//
import com.school.model.Course;
import com.school.model.Teacher;
import com.school.model.Student;
import com.school.exception.UserNotFoundException;
import com.school.service.FileHandler;

// importing the operators we needed for this file//
import java.util.ArrayList;
import java.util.List;

public class Managementservice {
    // creating database for arrays
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    // creating constructors to allocate memory spaces
    public Managementservice() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();

    }
    // -----Core Database insertions

    public void addStudent(Student student) {
        this.students.add(student);
        System.out.println("engine stared " + student.getName() + "was succesfully added");
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        System.out.println("engine stared " + teacher.getName() + "was succesfully added");
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        System.out.println("engine started " + course.getCourseName() + "was succesfully added");
    }

    // -------directory display operations
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        System.out.println("list of students in our database");
        for (Student s : students) {
            s.displayDashboard();
            System.out.println();
        }
    }

    //---------securing exception search engines in phase 3//
    public Student findStudentById(int id) throws UserNotFoundException {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;

            }
        }
        throw new UserNotFoundException("User not found");
    }

    // CHANGE: Change the throws declaration to UserNotFoundException
    public Course findCourseBycourseId(int courseId) throws UserNotFoundException {
        for (Course course : courses) {
            if (course.getcourseId() == courseId) {
                return course;
            }
        }
        // FIX: Throw UserNotFoundException when a course is missing from the directory
        throw new UserNotFoundException("❌ Database Error: Course with ID " + courseId + " does not exist in the catalog.");
    }

    // --------enrollment mechanism//
    public void enrollStudentInCourse(int studentId, int courseId) {
        try {
            // These methods will either return valid objects or break directly to the catch block below
            Student student = findStudentById(studentId);
            Course course = findCourseBycourseId(courseId);

            // Print confirmation since your current models don't have secondary set validation yet
            System.out.println("🎉 Success: " + student.getName() + " has been assigned to course " + course.getCourseName());

        } catch (UserNotFoundException e) {
            // Displays your custom exception message cleanly without crashing the console application
            System.out.println(e.getMessage());
        }
    }
    //link operation 1 ---> saving this live database memory to the file reader
   public void   saveAllData(){
        //as saveStudent is static we can call it by its classname
        FileHandler.saveStudents(this.students);
    }
    // 📂 LINKING OPERATION 2: Overwrite current memory list with data recovered from disk
    public  void loadAllData(){
        this.students = FileHandler.loadStudents();
   }

}