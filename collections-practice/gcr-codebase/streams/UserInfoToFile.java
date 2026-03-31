import java.io.*;

public class UserInfoToFile {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = null;

        try {
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(br.readLine());

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            writer = new FileWriter("user_info.txt"); // creates file if not exists

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");

            System.out.println("User information saved to user_info.txt");

        } catch (IOException e) {
            System.out.println("Input/Output error occurred: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Invalid age entered. Please enter a number.");

        } finally {
            try {
                if (writer != null) writer.close();
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing resources.");
            }
        }
    }
}
