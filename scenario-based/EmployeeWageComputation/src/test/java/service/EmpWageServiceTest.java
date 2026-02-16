package service;

import model.CompanyEmpWage;
import repository.CompanyRepository;
import repository.InMemoryCompanyRepository;
import exception.EmployeeWageException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpWageServiceTest {

    private EmpWageService service;
    private CompanyRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryCompanyRepository();
        service = new EmpWageServiceImpl(repository);
    }

    @Test
    void shouldAddCompanySuccessfully() {
        service.addCompany("TCS", 20, 20, 100);

        CompanyEmpWage company = repository.findByCompanyName("TCS");

        assertNotNull(company);
        assertEquals("TCS", company.getCompanyName());
    }

    @Test
    void shouldThrowExceptionForInvalidCompanyName() {
        assertThrows(EmployeeWageException.class, () -> {
            service.addCompany("123TCS", 20, 20, 100);
        });
    }

    @Test
    void shouldComputeTotalWage() {
        service.addCompany("Infosys", 25, 20, 100);

        service.computeWages();

        int totalWage = service.getTotalWage("Infosys");

        assertTrue(totalWage >= 0);
    }

    @Test
    void shouldThrowExceptionWhenCompanyNotFound() {
        assertThrows(EmployeeWageException.class, () -> {
            service.getTotalWage("UnknownCompany");
        });
    }
}
