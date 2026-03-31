package com.example;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJsonApp {
    public static void main(String[] args) throws Exception {
        File csvFile = new File("data.csv"); // Example CSV file

        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvFile);
        List<Map<String, String>> list = it.readAll();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }
}
