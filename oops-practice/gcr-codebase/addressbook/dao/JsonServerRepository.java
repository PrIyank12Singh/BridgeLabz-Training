package dao;

import model.ContactPerson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonServerRepository {

    private static final String SERVER_URL = "http://localhost:3000/contacts";
    private static final Gson gson = new Gson();

    public void saveContacts(List<ContactPerson> contacts) {
        try {
            URL url = new URL(SERVER_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = gson.toJson(contacts);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 201 || responseCode == 200) {
                System.out.println("Contacts saved to JSONServer successfully!");
            } else {
                System.out.println("Failed to save to JSONServer. Response Code: " + responseCode);
            }
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("JSONServer save error: " + e.getMessage());
        }
    }

    public List<ContactPerson> loadContacts() {
        List<ContactPerson> contacts = new ArrayList<>();
        try {
            URL url = new URL(SERVER_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                try (InputStreamReader reader = new InputStreamReader(conn.getInputStream())) {
                    Type listType = new TypeToken<List<ContactPerson>>() {}.getType();
                    contacts = gson.fromJson(reader, listType);
                }
                System.out.println("Contacts loaded from JSONServer successfully!");
            } else {
                System.out.println("Failed to load from JSONServer. Response Code: " + responseCode);
            }
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("JSONServer load error: " + e.getMessage());
        }
        return contacts;
    }
}
