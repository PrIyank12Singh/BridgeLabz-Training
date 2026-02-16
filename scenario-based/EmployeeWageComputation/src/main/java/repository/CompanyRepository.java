package repository;

import model.CompanyEmpWage;

import java.util.List;

public interface CompanyRepository {

    void save(CompanyEmpWage company);

    CompanyEmpWage findByCompanyName(String companyName);

    List<CompanyEmpWage> findAll();
}
