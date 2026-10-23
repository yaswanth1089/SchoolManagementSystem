package com.school.model;

// 📄 ADD THESE IMPORTS: Bringing in the Java Collections tools
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;




// FIX: Moved out of com.school to group it inside the model directory

public class Student extends User {
    // FIX: Capitalized 'Student' to follow standard Java PascalCase
    private double gpa;
    // adding these to enacpsulate our data relation structures
    private Set<String> enrolledCourses; // Tracks unique Course IDs as text strings
    private Map<String, String> grades; // Key: Course ID String -> Value: Grade Strings



    public Student(int id, String name, String email, double gpa) {
        super(id, name, email);
        this.gpa = gpa;
        //allocates empty memory trays for data collection storges
        this.enrolledCourses = new HashSet<>();
        this.grades = new HashMap<>();
    }

    public double getGpa() { return gpa; }

    // FIX: Changed return type from double to void. Setters exist to change values, they shouldn't return values.
    public void setGpa(double gpa) {
        this.gpa = gpa;

    }
    // 📄 ADD THIS GETTER: Grabs the student's unique course listing array sheet
    public Set<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    // 📄 ADD THIS GETTER: Grabs the student's digital report card mapping grid
    public Map<String, String> getGrades() {
        return grades;
    }


    @Override
    public void displayDashboard(){
        System.out.println("=== Student Dashboard ===");
        System.out.println("Name: " + getName());   // FIX: Updated to camelCase getName() from parent
        System.out.println("Email: " + getEmail()); // FIX: Updated to camelCase getEmail() from parent
        System.out.println("GPA: " + getGpa());     // FIX: Updated to camelCase getGpa()
        System.out.println("=========================");
    }
}
