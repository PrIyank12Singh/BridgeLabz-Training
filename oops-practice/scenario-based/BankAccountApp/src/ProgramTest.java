import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void testDepositValidAmount() {
        Program account = new Program(1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        Program account = new Program(1000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-200);
        });

        assertEquals("Deposit amount cannot be negative", exception.getMessage());
    }

    @Test
    void testWithdrawValidAmount() {
        Program account = new Program(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Program account = new Program(1000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });

        assertEquals("Insufficient funds.", exception.getMessage());
    }
}
