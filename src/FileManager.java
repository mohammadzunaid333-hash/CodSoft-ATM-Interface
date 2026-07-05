import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String ACCOUNT_FILE = "data/accounts.txt";
    private static final String TRANSACTION_FILE = "data/transactions.txt";

    // ==========================
    // Save Account Details
    // ==========================

    public static void saveAccount(BankAccount account) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNT_FILE, true))) {

            writer.write(account.getAccountNumber() + ",");
            writer.write(account.getAccountHolderName() + ",");
            writer.write(account.getAccountType() + ",");
            writer.write(account.getIfscCode() + ",");
            writer.write(account.getBranchName() + ",");
            writer.write(account.getBalance() + "");

            writer.newLine();

        } catch (IOException e) {

            System.out.println("Error Saving Account.");

        }

    }

    // ==========================
    // Save Transaction
    // ==========================

    public static void saveTransaction(Transaction transaction) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTION_FILE, true))) {

            writer.write(transaction.toString());

            writer.newLine();

        } catch (IOException e) {

            System.out.println("Error Saving Transaction.");

        }

    }

    // ==========================
    // Read Accounts
    // ==========================

    public static ArrayList<String> readAccounts() {

        ArrayList<String> accounts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                accounts.add(line);

            }

        } catch (IOException e) {

            System.out.println("No Account Data Found.");

        }

        return accounts;

    }

    // ==========================
    // Read Transactions
    // ==========================

    public static ArrayList<String> readTransactions() {

        ArrayList<String> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTION_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                transactions.add(line);

            }

        } catch (IOException e) {

            System.out.println("No Transaction Data Found.");

        }

        return transactions;

    }

}