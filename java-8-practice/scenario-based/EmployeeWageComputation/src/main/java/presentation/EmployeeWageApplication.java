package presentation;

import repository.CompanyRepository;
import repository.InMemoryCompanyRepository;
import service.EmpWageService;
import service.EmpWageServiceImpl;
import exception.EmployeeWageException;

import java.util.List;
import java.util.Scanner;

public class EmployeeWageApplication {

    public static void main(String[] args) {

        CompanyRepository repository = new InMemoryCompanyRepository();
        EmpWageService service = new EmpWageServiceImpl(repository);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Employee Wage Management System =====");
            System.out.println("1. Add Company");
            System.out.println("2. Compute Wages");
            System.out.println("3. Get Total Wage by Company");
            System.out.println("4. View Daily Wages");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:
                        System.out.print("Enter Company Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Wage Per Hour: ");
                        int wagePerHour = scanner.nextInt();

                        System.out.print("Enter Max Working Days: ");
                        int maxDays = scanner.nextInt();

                        System.out.print("Enter Max Working Hours: ");
                        int maxHours = scanner.nextInt();
                        scanner.nextLine();

                        service.addCompany(name, wagePerHour, maxDays, maxHours);
                        System.out.println("Company added successfully!");
                        break;

                    case 2:
                        service.computeWages();
                        System.out.println("Wages computed successfully!");
                        break;

                    case 3:
                        System.out.print("Enter Company Name: ");
                        String companyName = scanner.nextLine();

                        int totalWage = service.getTotalWage(companyName);
                        System.out.println("Total Wage for " + companyName + ": " + totalWage);
                        break;

                    case 4:
                        System.out.print("Enter Company Name: ");
                        String compName = scanner.nextLine();

                        List<Integer> dailyWages = service.getDailyWages(compName);
                        System.out.println("Daily Wages for " + compName + ": " + dailyWages);
                        break;

                    case 5:
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (EmployeeWageException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        scanner.close();
    }
}
