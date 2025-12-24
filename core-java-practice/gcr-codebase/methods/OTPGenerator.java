public class OTPGenerator {

    // Method to generate 6-digit OTP using Math.random()
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Main Method
    public static void main(String[] args) {

        int[] otpArr = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < 10; i++) {
            otpArr[i] = generateOTP();
        }

        // Display OTPs
        System.out.println("Generated OTPs:");
        for (int otp : otpArr) {
            System.out.println(otp);
        }

        // Check uniqueness
        if (areOTPsUnique(otpArr)) {
            System.out.println("\nAll OTPs are unique");
        } else {
            System.out.println("\nDuplicate OTP found");
        }
    }
}
