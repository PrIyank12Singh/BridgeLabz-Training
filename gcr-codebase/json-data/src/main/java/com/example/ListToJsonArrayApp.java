package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonArrayApp {
    static class Student {
        private String name;
        private int age;

        public Student() {}
        public Student(String name, int age) { this.name = name; this.age = age; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 24),
                new Student("Bob", 26),
                new Student("Charlie", 22)
        );

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonArray = mapper.writeValueAsString(students);
            System.out.println("JSON Array: " + jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
