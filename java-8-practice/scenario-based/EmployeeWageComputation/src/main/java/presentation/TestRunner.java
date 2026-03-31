package presentation;

import repository.CompanyRepository;
import repository.InMemoryCompanyRepository;
import service.EmpWageService;
import service.EmpWageServiceImpl;

public class TestRunner {

    public static void main(String[] args) {

        System.out.println("Running Employee Wage Test...");

        CompanyRepository repository = new InMemoryCompanyRepository();

        EmpWageService service = new EmpWageServiceImpl(repository);

        service.addCompany("TCS", 20, 20, 100);
        service.addCompany("Infosys", 25, 22, 120);

        service.computeWages();

        int tcsWage = service.getTotalWage("TCS");
        int infosysWage = service.getTotalWage("Infosys");

        System.out.println("TCS Total Wage: " + tcsWage);
        System.out.println("Infosys Total Wage: " + infosysWage);
    }
}
