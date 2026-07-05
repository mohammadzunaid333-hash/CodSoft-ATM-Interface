import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {

    public static void printReceipt(
            String transactionId,
            String accountNumber,
            String type,
            double amount,
            double balance) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println();

        Utils.printLine();

        System.out.println("           ADVANCED ATM RECEIPT");

        Utils.printLine();

        System.out.println("Transaction ID : " + transactionId);

        System.out.println("Account Number : " + accountNumber);

        System.out.println("Transaction    : " + type);

        System.out.println("Amount         : ₹" + amount);

        System.out.println("Balance        : ₹" + balance);

        System.out.println("Status         : SUCCESS");

        System.out.println("Date & Time    : "
                + LocalDateTime.now().format(formatter));

        Utils.printLine();

        System.out.println("Thank You For Banking With Us");

        Utils.printLine();

    }

}