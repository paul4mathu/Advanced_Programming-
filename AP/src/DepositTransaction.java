import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Deposited " + amount + " to account: " + ba.getAccountNumber());
    }
}
