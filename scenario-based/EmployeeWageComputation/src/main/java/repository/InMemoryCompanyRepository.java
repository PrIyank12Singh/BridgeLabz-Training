package repository;

import model.CompanyEmpWage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCompanyRepository implements CompanyRepository {

    private Map<String, CompanyEmpWage> companyMap;

    public InMemoryCompanyRepository() {
        companyMap = new HashMap<>();
    }

    @Override
    public void save(CompanyEmpWage company) {
        companyMap.put(company.getCompanyName(), company);
    }

    @Override
    public CompanyEmpWage findByCompanyName(String companyName) {
        return companyMap.get(companyName);
    }

    @Override
    public List<CompanyEmpWage> findAll() {
        return new ArrayList<>(companyMap.values());
    }
}
