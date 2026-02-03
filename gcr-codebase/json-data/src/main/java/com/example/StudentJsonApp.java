package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class StudentJsonApp {
    public static void main(String[] args) {
        // 1. Create Student object
        Student student = new Student("Priyank Singh", 22, Arrays.asList("Mathematics", "Physics", "Computer Science"));

        // 2. Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        try {
            // 3. Convert Student object to JSON and save to file
            mapper.writeValue(new File("student.json"), student);

            // 4. Read JSON from file and convert back to Student object
            Student readStudent = mapper.readValue(new File("student.json"), Student.class);

            // 5. Print the read object
            System.out.println("Student read from JSON: " + readStudent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
