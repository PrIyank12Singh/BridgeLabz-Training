import java.util.*;

class FileVersion {

    String versionName;
    int size;

    FileVersion(String versionName, int size) {
        this.versionName = versionName;
        this.size = size;
    }
}

class StoredFile {

    String fileName;
    Map<String, FileVersion> versionMap = new HashMap<>();
    List<String> uploadOrder = new ArrayList<>();

    StoredFile(String fileName) {
        this.fileName = fileName;
    }

    void upload(String version, int size) {

        if (!versionMap.containsKey(version)) {
            FileVersion v = new FileVersion(version, size);
            versionMap.put(version, v);
            uploadOrder.add(version);
        }
    }

    void fetch() {

        List<FileVersion> list = new ArrayList<>(versionMap.values());

        list.sort((a, b) -> {
            if (a.size != b.size)
                return a.size - b.size;
            return a.versionName.compareTo(b.versionName);
        });

        for (FileVersion v : list) {
            System.out.println(fileName + " " + v.versionName + " " + v.size);
        }
    }

    void latest() {

        if (uploadOrder.isEmpty()) {
            System.out.println("File Not Found");
            return;
        }

        String vName = uploadOrder.get(uploadOrder.size() - 1);
        FileVersion v = versionMap.get(vName);

        System.out.println(fileName + " " + v.versionName + " " + v.size);
    }

    void totalStorage() {

        int sum = 0;
        for (FileVersion v : versionMap.values())
            sum += v.size;

        System.out.println(fileName + " " + sum);
    }
}

class StorageService {

    Map<String, StoredFile> files = new HashMap<>();

    void upload(String file, String version, int size) {
        files.putIfAbsent(file, new StoredFile(file));
        files.get(file).upload(version, size);
    }

    void fetch(String file) {
        if (!files.containsKey(file)) {
            System.out.println("File Not Found");
            return;
        }
        files.get(file).fetch();
    }

    void latest(String file) {
        if (!files.containsKey(file)) {
            System.out.println("File Not Found");
            return;
        }
        files.get(file).latest();
    }

    void totalStorage(String file) {
        if (!files.containsKey(file)) {
            System.out.println("File Not Found");
            return;
        }
        files.get(file).totalStorage();
    }
}

public class VersionControlledStorageSystemApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        StorageService service = new StorageService();

        while (n-- > 0) {

            String line = sc.nextLine();
            String[] p = line.split(" ");

            switch (p[0]) {

                case "UPLOAD":
                    service.upload(p[1], p[2], Integer.parseInt(p[3]));
                    break;

                case "FETCH":
                    service.fetch(p[1]);
                    break;

                case "LATEST":
                    service.latest(p[1]);
                    break;

                case "TOTAL_STORAGE":
                    service.totalStorage(p[1]);
                    break;
            }
        }
    }
}