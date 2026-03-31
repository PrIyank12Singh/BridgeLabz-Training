package dao;

import java.util.HashMap;
import java.util.Map;

public class RepositoryFactory {

    private static Map<String, Object> repositoryMap = new HashMap<>();

    public static Object getRepository(String type) {
        switch (type.toLowerCase()) {
            case "database":
                return repositoryMap.computeIfAbsent("database", k -> new DatabaseRepository());
            case "jsonserver":
                return repositoryMap.computeIfAbsent("jsonserver", k -> new JsonServerRepository());
            default:
                throw new IllegalArgumentException("Unknown repository type: " + type);
        }
    }
}
