package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Model class representing IPL match
class IPLMatch {
    public int match_id;
    public String team1;
    public String team2;
    public int score_team1;
    public int score_team2;
    public String winner;
    public String player_of_match;

    // Default constructor required for Jackson
    public IPLMatch() {}

    public IPLMatch(int match_id, String team1, String team2, int score_team1, int score_team2, String winner, String player_of_match) {
        this.match_id = match_id;
        this.team1 = team1;
        this.team2 = team2;
        this.score_team1 = score_team1;
        this.score_team2 = score_team2;
        this.winner = winner;
        this.player_of_match = player_of_match;
    }
}

public class IPLCensorAnalyzer {

    // Apply censorship rules
    private static void censorMatch(IPLMatch match) {
        // Mask team names: keep first word, mask rest
        match.team1 = maskTeamName(match.team1);
        match.team2 = maskTeamName(match.team2);
        match.winner = maskTeamName(match.winner);

        // Redact player of the match
        match.player_of_match = "REDACTED";
    }

    private static String maskTeamName(String team) {
        String[] parts = team.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ***";
        }
        return team;
    }

    // Process JSON input
    public static void processJson(String inputFile, String outputFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON into List<IPLMatch>
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, IPLMatch.class);
        List<IPLMatch> matches = mapper.readValue(new File(inputFile), listType);

        // Apply censorship
        for (IPLMatch match : matches) {
            censorMatch(match);
        }

        // Write censored JSON
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
        System.out.println("Censored JSON written to: " + outputFile);
    }

    // Process CSV input
    public static void processCsv(String inputFile, String outputFile) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        List<IPLMatch> matches = new ArrayList<>();
        // Read CSV rows into List<IPLMatch>
        matches = csvMapper.readerFor(IPLMatch.class).with(schema).readValues(new File(inputFile)).readAll();

        // Apply censorship
        for (IPLMatch match : matches) {
            censorMatch(match);
        }

        // Write censored CSV
        CsvSchema outputSchema = csvMapper.schemaFor(IPLMatch.class).withHeader();
        csvMapper.writer(outputSchema).writeValue(new File(outputFile), matches);
        System.out.println("Censored CSV written to: " + outputFile);
    }

    // Main method
    public static void main(String[] args) {
        try {
            // Process JSON
            processJson("ipl_input.json", "ipl_censored.json");

            // Process CSV
            processCsv("ipl_input.csv", "ipl_censored.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
