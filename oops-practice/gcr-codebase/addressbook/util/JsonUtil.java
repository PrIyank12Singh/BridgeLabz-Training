package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.ContactPerson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void writeContactsToJson(String filePath, List<ContactPerson> contacts) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(contacts, writer);
            System.out.println("Contacts saved to JSON file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing JSON: " + e.getMessage());
        }
    }

    public static List<ContactPerson> readContactsFromJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type contactListType = new TypeToken<List<ContactPerson>>() {}.getType();
            return gson.fromJson(reader, contactListType);
        } catch (IOException e) {
            System.out.println("Error reading JSON: " + e.getMessage());
            return null;
        }
    }
}
