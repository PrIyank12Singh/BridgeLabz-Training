package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterJsonByAgeApp {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("users.json")); // JSON array file

        for (JsonNode user : root) {
            if (user.get("age").asInt() > 25) {
                System.out.println(user.toString());
            }
        }
    }
}
