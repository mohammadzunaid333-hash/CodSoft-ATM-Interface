import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String transactionId;
    private String type;
    private double amount;
    private double balance;
    private LocalDateTime dateTime;

    public Transaction(String transactionId, String type, double amount, double balance) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.dateTime = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }

    @Override
    public String toString() {
        return String.format(
                "%-8s %-10s ₹%-10.2f ₹%-10.2f %s",
                transactionId,
                type,
                amount,
                balance,
                getDateTime()
        );
    }
}