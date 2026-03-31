import java.io.*;

public class StudentDataStreamDemo {

    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {

        // Sample student data
        int rollNumber = 101;
        String name = "Priyank";
        double gpa = 8.75;

        writeStudentData(rollNumber, name, gpa);
        readStudentData();
    }

    // Write data using DataOutputStream
    public static void writeStudentData(int roll, String name, double gpa) {

        try (DataOutputStream dos =
                      new DataOutputStream(new FileOutputStream(FILE_NAME))) {

            dos.writeInt(roll);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    // Read data using DataInputStream
    public static void readStudentData() {

        try (DataInputStream dis =
                      new DataInputStream(new FileInputStream(FILE_NAME))) {

            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nStudent data read from file:");
            System.out.println("Roll Number: " + roll);
            System.out.println("Name       : " + name);
            System.out.println("GPA        : " + gpa);

        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
