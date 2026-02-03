package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonApp {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // First JSON
            String json1 = "{\"name\":\"Priyank Singh\",\"age\":22}";
            // Second JSON
            String json2 = "{\"email\":\"priyank@example.com\",\"city\":\"Delhi\"}";

            // Convert to JsonNode
            ObjectNode node1 = (ObjectNode) mapper.readTree(json1);
            ObjectNode node2 = (ObjectNode) mapper.readTree(json2);

            // Merge node2 into node1
            node1.setAll(node2);

            System.out.println("Merged JSON: " + node1.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
