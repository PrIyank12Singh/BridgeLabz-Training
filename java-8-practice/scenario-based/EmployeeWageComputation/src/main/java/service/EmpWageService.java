package service;

import java.util.List;

public interface EmpWageService {

    void addCompany(String companyName,
                    int wagePerHour,
                    int maxWorkingDays,
                    int maxWorkingHours);

    void computeWages();

    int getTotalWage(String companyName);

    List<Integer> getDailyWages(String companyName);
}
