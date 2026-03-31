package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonApp {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String validJson = "{\"name\":\"Priyank\",\"age\":22}";
        String invalidJson = "{name:Priyank, age:22}"; // Missing quotes

        System.out.println("Validating valid JSON:");
        validateJson(mapper, validJson);

        System.out.println("Validating invalid JSON:");
        validateJson(mapper, invalidJson);
    }

    private static void validateJson(ObjectMapper mapper, String json) {
        try {
            mapper.readTree(json);
            System.out.println("Valid JSON");
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
