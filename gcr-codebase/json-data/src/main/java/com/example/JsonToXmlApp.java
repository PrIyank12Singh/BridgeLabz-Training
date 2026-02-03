package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class JsonToXmlApp {
    public static void main(String[] args) throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode node = jsonMapper.readTree(new File("user.json"));

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(node);
        System.out.println(xml);
    }
}
