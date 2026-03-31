import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file name: ");
        String sourceFile = sc.nextLine();

        System.out.print("Enter destination file name: ");
        String destinationFile = sc.nextLine();

        copyFile(sourceFile, destinationFile);
        sc.close();
    }

    public static void copyFile(String source, String destination) {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(source);      // throws error if file not found
            fos = new FileOutputStream(destination); // creates file if not exists

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Source file does not exist: " + source);

        } catch (IOException e) {
            System.out.println("Error while reading or writing the file.");

        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing files.");
            }
        }

      
    }
}
