package com.school.model;


public class Course { // FIX: Capitalized class name 'Course' so Main can map it properly
    private int courseId;    // FIX: Standardized variables using camelCase (courseId instead of courseid)
    private String courseName;
    private Teacher instructor;


    public Course(int courseId, String courseName, Teacher instructor){
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public int getcourseId() { return courseId; }

    // FIX: Setters must receive a parameter inside the parenthesis to actually update the class field!

    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Teacher getInstructor() { return instructor; }
    public void setInstructor(Teacher instructor) { this.instructor = instructor; }

    public void displayDashboard(){
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor.getName()); // Grabs the name inside the Teacher object
    }
}
