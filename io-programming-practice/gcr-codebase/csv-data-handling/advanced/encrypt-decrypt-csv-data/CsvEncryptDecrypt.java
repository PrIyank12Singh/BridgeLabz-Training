import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CsvEncryptDecrypt {

    // AES key (can be stored securely or generated)
    private static final String ALGORITHM = "AES";
    private static final byte[] keyBytes = "1234567890123456".getBytes(); // 16-byte key for AES-128

    // Encrypt string
    public static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypt string
    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec key = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encryptedData);
        return new String(cipher.doFinal(decoded));
    }

    // Write encrypted CSV
    public static void writeEncryptedCsv(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    bw.write(line); // write header as is
                    bw.newLine();
                    isHeader = false;
                    continue;
                }

                String[] fields = line.split(",");
                int empId = Integer.parseInt(fields[0]);
                String name = fields[1];
                String dept = fields[2];
                String salaryEnc = encrypt(fields[3]);
                String emailEnc = encrypt(fields[4]);

                EncryptedEmployeeRecord record = new EncryptedEmployeeRecord(empId, name, dept, salaryEnc, emailEnc);
                bw.write(record.toCsvRow());
                bw.newLine();
            }

            System.out.println("Encrypted CSV written to: " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read encrypted CSV and decrypt fields
    public static void readEncryptedCsv(String encryptedFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(encryptedFile))) {

            String line;
            boolean isHeader = true;
            List<EncryptedEmployeeRecord> records = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    System.out.println("Header: " + line);
                    isHeader = false;
                    continue;
                }

                String[] fields = line.split(",");
                int empId = Integer.parseInt(fields[0]);
                String name = fields[1];
                String dept = fields[2];
                String salaryDec = decrypt(fields[3]);
                String emailDec = decrypt(fields[4]);

                EncryptedEmployeeRecord record = new EncryptedEmployeeRecord(empId, name, dept, salaryDec, emailDec);
                records.add(record);
            }

            // Print decrypted records
            System.out.println("Decrypted Records:");
            for (EncryptedEmployeeRecord r : records) {
                System.out.println(r.getEmployeeId() + ", " + r.getName() + ", " + r.getDepartment()
                        + ", " + r.getSalary() + ", " + r.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputCsv = "employee_sensitive_input.csv";
        String encryptedCsv = "employee_sensitive_encrypted.csv";

        // Encrypt and write CSV
        writeEncryptedCsv(inputCsv, encryptedCsv);

        // Read encrypted CSV and decrypt fields
        readEncryptedCsv(encryptedCsv);
    }
}
