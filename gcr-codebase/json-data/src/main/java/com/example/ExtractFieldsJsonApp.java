package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ExtractFieldsJsonApp {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON from file
            JsonNode root = mapper.readTree(new File("user.json")); // user.json must exist

            // Extract specific fields
            String name = root.get("name").asText();
            String email = root.get("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
