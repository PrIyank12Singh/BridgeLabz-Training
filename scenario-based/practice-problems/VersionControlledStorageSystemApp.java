import java.util.*;

class FileVersion{
  String versionName;
  int size;

  FileVersion(String versionName, int size){
    this.versionName = versionName;
    this.size = size;
  }
}

class StoredFile{
  String fileName;
  Map<String, FileVersion> versionMap = new HashMap<>();
  List<String> uploadOrder = new ArrayList<>();

  StoredFile(String fileName) {
    this.fileName = fileName;
  }


  void upload(String version, int size){
    if (!versionMap.containsKey(version)) {
      FileVersion v = new FileVersion(version, size);
      versionMap.put(version, v);
      uploadOrder.add(version);
    }
  }

  void fetch(){

    List<FileVersion> list = new ArrayList<>()(versionMap.values());

    list.sort((a,b)->{
      if (a.size!= b.size) {
        return a.size - b.size;
      }

      return a.versionName.compareTo(b.versionName);
    });

    for(FileVersion v:list){
      System.out.println(fileName+" "+v.versionName+" "+v.size);
    }
  }
}
public class VersionControlledStorageSystemApp {
  
}
