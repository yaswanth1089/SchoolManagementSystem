package com.school.service;
import com.school.model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

///
//We want to create a method that takes our List<Student> and saves it.
public class FileHandler {


    private static final String FILE_PATH = "students.txt";

    public static void saveStudents(List<Student> students) {

        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(FILE_PATH))) {

            // looping this into our students list
            for (Student s : students) {
                // constructing single string (Line) seperating fileds by comma (,)
                String line = s.getId() + "," + s.getName() + "," + s.getEmail() + "," + s.getGpa();
                //write the line to our temporary buffer memory
                writer.write(line);
                //moving the curosor to brand new line for next student
                writer.newLine();
            }
            System.out.println("backup completed");
        } catch (java.io.IOException e) {
            //if the hard drive blocks us, this block catches the crash safely
            System.out.println("error savig the files " + e.getMessage());
        }


    }

    public static List<Student> loadStudents() {
        // creating a fresh list to store new students we read from the disk
        List<Student> loadedList = new ArrayList<>();

        // opening a bufferedreader linked to the file reader using the the locked  FILE_PATH//

        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(FILE_PATH))) {
            String line;
            // creating a loop through the file until it returns empty//

            while ((line = reader.readLine()) != null) {
                // we will break down each raw text line right here
                // cutting the lines into the pieces usinf the comma as our knife
                String tokens [] = line.split(",");
                //tokens[0] = "101"  | tokens[1] = "Tony Stark"
                // tokens[2] = "tony@starkindustries.com" | tokens[3] = "9.8"
                // 3. Convert text numbers back into real primitive integers and decimals
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                String email = tokens[2];
                double gpa = Double.parseDouble(tokens[3]);
                // 4. Re-instantiate a living Student object using the data from the disk!

                Student student = new Student (id, name, email, gpa);
                // adding these int the existing holding memory tray
                loadedList.add(student);


            }
            System.out.println("data loaded successfully from the harddrive ");
        } catch (IOException e) {
            // if the file does not  exist it handles the error
            System.out.println("no storge file found starting refresh");
        }
        return loadedList;


    }
}





