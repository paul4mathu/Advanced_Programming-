import java.util.Calendar;

public interface TransactionInterface {
    double getAmount();
    Calendar getDate();
    String getTransactionID();
    void printTransactionDetails();

    // throws InsufficientFundsException
    void apply(BankAccount ba) throws InsufficientFundsException;
}
