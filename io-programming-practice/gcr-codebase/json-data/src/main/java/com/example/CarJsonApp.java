package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class CarJsonApp {

    // Inner Car class
    static class Car {
        private String brand;
        private String model;
        private int year;

        // Default constructor
        public Car() {}

        // Parameterized constructor
        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        // Getters and Setters
        public String getBrand() { return brand; }
        public void setBrand(String brand) { this.brand = brand; }

        public String getModel() { return model; }
        public void setModel(String model) { this.model = model; }

        public int getYear() { return year; }
        public void setYear(int year) { this.year = year; }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", year=" + year +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Tesla", "Model 3", 2023);

        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert Car object to JSON string
            String carJson = mapper.writeValueAsString(car);
            System.out.println("Car as JSON: " + carJson);

            // Write JSON to file
            mapper.writeValue(new File("car.json"), car);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
