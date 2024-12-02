import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        // Create BankAccount object
        BankAccount account = new BankAccount("63196319", 5000.00);

        // DepositTransaction
        BaseTransaction deposit = new DepositTransaction(1000.00, Calendar.getInstance(), "PAA1");
        deposit.apply(account);
        deposit.printTransactionDetails();

        // WithdrawalTransaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(500.00, Calendar.getInstance(), "PAA2");

        try {
            withdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        withdrawal.printTransactionDetails();

        // Reversal of withdrawal
        withdrawal.reverse(account);

        // Large withdrawal - InsufficientFundsException
        WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(6500.00, Calendar.getInstance(), "PAA3");

        try {
            largeWithdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        largeWithdrawal.printTransactionDetails();

        // Partial withdrawal
        WithdrawalTransaction partialWithdrawal = new WithdrawalTransaction(2000.00, Calendar.getInstance(), "PAA4");

        try {
            partialWithdrawal.apply(account, true);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        partialWithdrawal.printTransactionDetails();

        // Final Account Balance
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}
