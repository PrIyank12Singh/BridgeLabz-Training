import java.util.*;
public class ShipmentManifestValidatorApp{
  
  static Set<String> VALID_MODES = new HashSet<>(
    Arrays.asList("AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT")
  );

  static Set<String> VALID_STATUS = new HashSet<>(Arrays.asList("DELIVERED", "CANCELLED", "IN_TRANSIT"));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in)  ;
    int n = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < n; i++) {
      String record = sc.nextLine().trim();
      if(isValidRecord(record)){
        System.out.println("COMPLIANT RECORD");
      }
      else{
        System.out.println("NON-COMPLIANT RECORD");
      }
    }
  }

  static boolean isValidRecord(String rec){

    String[] parts = rec.split("\\");
    if (parts.length!=5) {
      return false;
    }

    return isValidCode(parts[0])
            &&isValidDate(parts[1])
            &&isValidMode(parts[2])
            &&isValidWeight(parts[3])
            &&isValidStatus(parts[4]);
  }

  static boolean isValidCode(String code){
    if (!code.matches("SHIP-[1-9][0-9]{5}")) {
      return false;
    }

    String digits = code.substring(5);

    int count = 1;
    for (int i = 0; i < digits.length(); i++) {
      if (digits.charAt(i)==digits.charAt(i-1)) {
        count++;
        if (count>3) return false;
      } else{
        count = 1;
      }
    }
    return true;
  }

  static boolean isValidDate(String date){
    if (!date.matches("20\\d{2}-\\d{2}-\\d{2}")) {
      return false;
    }

    String[] d = date.split("-");
    int year = Integer.parseInt(d[0]);
    int month = Integer.parseInt(d[1]);
    int day = Integer.parseInt(d[2]);

    if (month<1 || month>12) {
      return false;
    }

    int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    if (isLeap(year)) days[1] = 29;

    return day>=1 && day<=days[month-1];
  }

  static boolean isLeap(int y){
    return (y%400==0) || (y%4==0 && y%100!=0);
  }

  static boolean isValidMode(String mode){
    return VALID_MODES.contains(mode);
  }

  static boolean isValidWeight(String w){
    if (!w.matches("(0|[1-9]\\d{0-5})(\\.\\d{1,2})?")) {
      return false;
    }

    double val = Double.parseDouble(w);
    return val>=0 && val<=999999.99;
  }

  static boolean isValidStatus(String s){
    return VALID_STATUS.contains(s);
  }
}