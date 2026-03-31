package util;

import exception.EmployeeWageException;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String COMPANY_NAME_REGEX = "^[A-Za-z]{2,}$";

    public static void validateCompanyName(String companyName) {

        if (companyName == null ||
                !Pattern.matches(COMPANY_NAME_REGEX, companyName)) {

            throw new EmployeeWageException(
                    "Invalid Company Name. Only alphabets allowed, minimum 2 characters."
            );
        }
    }
}
