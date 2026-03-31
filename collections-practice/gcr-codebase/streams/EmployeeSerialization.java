import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {

    // Employee class in same file
    static class Employee implements Serializable {

        private static final long serialVersionUID = 1L;

        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee {" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        // Sample data
        employees.add(new Employee(1, "Amit", "IT", 55000));
        employees.add(new Employee(2, "Neha", "HR", 48000));
        employees.add(new Employee(3, "Rahul", "Finance", 60000));

        serializeEmployees(employees);
        deserializeEmployees();
    }

    // Serialize list
    public static void serializeEmployees(List<Employee> employees) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");

        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Deserialize list
    @SuppressWarnings("unchecked")
    public static void deserializeEmployees() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            List<Employee> employees = (List<Employee>) ois.readObject();

            System.out.println("\nEmployees read from file:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }

        } catch (IOException e) {
            System.out.println("Error during deserialization: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found.");
        }
    }
}
