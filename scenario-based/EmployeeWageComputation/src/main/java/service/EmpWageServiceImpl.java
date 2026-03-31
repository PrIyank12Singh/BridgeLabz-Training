package service;

import model.CompanyEmpWage;
import repository.CompanyRepository;
import exception.EmployeeWageException;

import java.util.List;

public class EmpWageServiceImpl implements EmpWageService {

    private CompanyRepository companyRepository;

    public EmpWageServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void addCompany(String companyName,
                           int wagePerHour,
                           int maxWorkingDays,
                           int maxWorkingHours) {

        CompanyEmpWage company = new CompanyEmpWage(
                companyName,
                wagePerHour,
                maxWorkingDays,
                maxWorkingHours
        );

        companyRepository.save(company);
    }

    @Override
    public void computeWages() {

        List<CompanyEmpWage> companies = companyRepository.findAll();

        for (CompanyEmpWage company : companies) {
            company.computeEmpWage();
        }
    }

    @Override
    public int getTotalWage(String companyName) {

        CompanyEmpWage company =
                companyRepository.findByCompanyName(companyName);

        if (company == null) {
            throw new EmployeeWageException(
                    "Company with name '" + companyName + "' not found."
            );
        }

        return company.getTotalEmpWage();
    }

    @Override
    public List<Integer> getDailyWages(String companyName) {

        CompanyEmpWage company =
                companyRepository.findByCompanyName(companyName);

        if (company == null) {
            throw new EmployeeWageException(
                    "Company with name '" + companyName + "' not found."
            );
        }

        return company.getDailyWages();
    }
}
