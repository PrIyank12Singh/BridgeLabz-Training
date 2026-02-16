package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CompanyEmpWage {

    private String companyName;
    private int wagePerHour;
    private int maxWorkingDays;
    private int maxWorkingHours;

    private int totalEmpWage;
    private List<Integer> dailyWages;

    public CompanyEmpWage(String companyName,
                          int wagePerHour,
                          int maxWorkingDays,
                          int maxWorkingHours) {

        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.dailyWages = new ArrayList<>();
    }

    public void computeEmpWage() {

        int totalWorkingDays = 0;
        int totalWorkingHours = 0;

        Random random = new Random();

        while (totalWorkingDays < maxWorkingDays &&
               totalWorkingHours < maxWorkingHours) {

            totalWorkingDays++;

            int empCheck = random.nextInt(3);
            int empHours = 0;

            switch (empCheck) {
                case 1:
                    empHours = 4;  // Part-time
                    break;
                case 2:
                    empHours = 8;  // Full-time
                    break;
                default:
                    empHours = 0;  // Absent
            }

            totalWorkingHours += empHours;

            int dailyWage = empHours * wagePerHour;
            dailyWages.add(dailyWage);
        }

        totalEmpWage = totalWorkingHours * wagePerHour;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getTotalEmpWage() {
        return totalEmpWage;
    }

    public List<Integer> getDailyWages() {
        return dailyWages;
    }
}
