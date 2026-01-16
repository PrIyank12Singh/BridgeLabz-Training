public class ConcatenateUsingStringBuffer {
  public static void main(String[] args) {
    String[] arr = {"Hello"," ","World","!"," Welcome"," to"," Java"};

    String result = concatenateStrings(arr);

    System.out.println("Concatenated String:");
    System.out.println(result);
  }

  public static String concatenateStrings(String[] arr){

    //create StringBuffer
    StringBuffer buffer = new StringBuffer();

    //append each string
    for(String str:arr){
      buffer.append(str);
    }

    return buffer.toString();

    
  }
}
