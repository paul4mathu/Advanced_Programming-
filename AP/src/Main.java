import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        //  BankAccount object
        BankAccount account = new BankAccount("63196319", 5000.00);

        // DepositTransaction 
        BaseTransaction deposit = new DepositTransaction(1000.00, Calendar.getInstance(), "PAA1");
        deposit.apply(account);  // Deposit
        deposit.printTransactionDetails();  // depo details

        // WithdrawalTransaction 
        BaseTransaction withdrawal = new WithdrawalTransaction(500.00, Calendar.getInstance(), "PAA2");

        try {
            withdrawal.apply(account);  
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        withdrawal.printTransactionDetails();  //withdrawal details

        // large withdrawal - InsufficientFundsException
        BaseTransaction largeWithdrawal = new WithdrawalTransaction(6500.00, Calendar.getInstance(), "PAA3");

        try {
            largeWithdrawal.apply(account); 
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        largeWithdrawal.printTransactionDetails();

        //Final Account Balance
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}
