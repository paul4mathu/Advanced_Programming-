import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        ba.withdraw(amount);
        System.out.println("Withdrew " + amount + " from account: " + ba.getAccountNumber());
    }

    // Reversal of a transaction
    public boolean reverse(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Reversed withdrawal of " + amount + " to account: " + ba.getAccountNumber());
        return true;
    }

    // Overloaded apply method for partial withdrawals
    public void apply(BankAccount ba, boolean partialWithdrawalAllowed) throws InsufficientFundsException {
        if (!partialWithdrawalAllowed || ba.getBalance() >= amount) {
            apply(ba);
        } else if (ba.getBalance() > 0) {
            double available = ba.getBalance();
            ba.withdraw(available);
            System.out.println("Partially withdrew " + available + ". Remaining amount not withdrawn: " + (amount - available));
        } else {
            throw new InsufficientFundsException("Insufficient funds for partial withdrawal.");
        }
    }
}
