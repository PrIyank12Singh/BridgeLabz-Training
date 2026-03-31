package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import java.io.File;

public class ValidateEmailJsonApp {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new File("user.json"));

        // JSON Schema (email pattern)
        String schemaStr = "{ \"type\":\"object\", \"properties\":{ \"email\":{\"type\":\"string\",\"format\":\"email\"} }, \"required\":[\"email\"] }";
        JSONObject rawSchema = new JSONObject(schemaStr);
        Schema schema = SchemaLoader.load(rawSchema);

        schema.validate(new JSONObject(jsonNode.toString())); // throws exception if invalid
        System.out.println("Email is valid!");
    }
}
