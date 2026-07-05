import java.util.ArrayList;

public class BankAccount {

    // ==========================
    // Account Information
    // ==========================

    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private String ifscCode;
    private String branchName;

    // ==========================
    // Security
    // ==========================

    private int pin;
    private int wrongAttempts;
    private boolean accountLocked;

    // ==========================
    // Money
    // ==========================

    private double balance;
    private double totalDeposited;
    private double totalWithdrawn;

    // ==========================
    // Transactions
    // ==========================

    private ArrayList<Transaction> transactionHistory;

    private int transactionCounter;

    // ==========================
    // Constructor
    // ==========================

    public BankAccount(
            String accountNumber,
            String accountHolderName,
            String accountType,
            String ifscCode,
            String branchName,
            int pin,
            double openingBalance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.ifscCode = ifscCode;
        this.branchName = branchName;

        this.pin = pin;

        this.balance = openingBalance;

        this.totalDeposited = 0;

        this.totalWithdrawn = 0;

        this.wrongAttempts = 0;

        this.accountLocked = false;

        this.transactionCounter = 1;

        transactionHistory = new ArrayList<>();

    }

    // ==========================
    // Getters
    // ==========================

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    // ==========================
    // Transaction ID Generator
    // ==========================

    private String generateTransactionId() {

        String id = "TXN" + String.format("%05d", transactionCounter);

        transactionCounter++;

        return id;

    }
        // ==========================
    // Deposit Money
    // ==========================

    public void deposit(double amount) {

        if (accountLocked) {
            Utils.printError("Account is Locked.");
            return;
        }

        if (amount <= 0) {
            Utils.printError("Invalid Deposit Amount.");
            return;
        }

        balance += amount;
        totalDeposited += amount;

        transactionHistory.add(
                new Transaction(
                        generateTransactionId(),
                        "DEPOSIT",
                        amount,
                        balance
                )
        );

        Utils.printSuccess("₹" + amount + " deposited successfully.");
    }

    // ==========================
    // Withdraw Money
    // ==========================

    public void withdraw(double amount) {

        if (accountLocked) {
            Utils.printError("Account is Locked.");
            return;
        }

        if (amount <= 0) {
            Utils.printError("Invalid Withdrawal Amount.");
            return;
        }

        if (amount > balance) {
            Utils.printError("Insufficient Balance.");
            return;
        }

        if (amount % 100 != 0) {
            Utils.printError("Withdrawal must be in multiples of ₹100.");
            return;
        }

        balance -= amount;
        totalWithdrawn += amount;

        transactionHistory.add(
                new Transaction(
                        generateTransactionId(),
                        "WITHDRAW",
                        amount,
                        balance
                )
        );

        Utils.printSuccess("₹" + amount + " withdrawn successfully.");
    }

    // ==========================
    // Check Balance
    // ==========================

    public void checkBalance() {

        Utils.printTitle("ACCOUNT BALANCE");

        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Current Balance: ₹" + balance);

        Utils.printLine();
    }

    // ==========================
    // Account Details
    // ==========================

    public void showAccountDetails() {

        Utils.printTitle("ACCOUNT DETAILS");

        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Type   : " + accountType);
        System.out.println("IFSC Code      : " + ifscCode);
        System.out.println("Branch Name    : " + branchName);
        System.out.println("Current Balance: ₹" + balance);

        Utils.printLine();
    }
        // ==========================
    // Transaction History
    // ==========================

    public void showTransactionHistory() {

        Utils.printTitle("TRANSACTION HISTORY");

        if (transactionHistory.isEmpty()) {
            Utils.printError("No transactions found.");
            return;
        }

        System.out.printf("%-10s %-12s %-12s %-12s %-20s%n",
                "ID", "TYPE", "AMOUNT", "BALANCE", "DATE & TIME");

        Utils.printLine();

        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }

        Utils.printLine();
    }

    // ==========================
    // Change PIN
    // ==========================

    public void changePin(int oldPin, int newPin) {

        if (accountLocked) {
            Utils.printError("Account is locked.");
            return;
        }

        if (oldPin != pin) {
            Utils.printError("Incorrect current PIN.");
            return;
        }

        pin = newPin;
        Utils.printSuccess("PIN changed successfully.");
    }

    // ==========================
    // Login Validation
    // ==========================

    public boolean validatePin(int enteredPin) {

        if (accountLocked) {
            return false;
        }

        if (enteredPin == pin) {
            wrongAttempts = 0;
            return true;
        }

        wrongAttempts++;

        if (wrongAttempts >= 3) {
            accountLocked = true;
            Utils.printError("Account locked due to 3 incorrect PIN attempts.");
        }

        return false;
    }

    // ==========================
    // Statistics
    // ==========================

    public void showStatistics() {

        Utils.printTitle("ACCOUNT STATISTICS");

        System.out.println("Total Deposited  : ₹" + totalDeposited);
        System.out.println("Total Withdrawn  : ₹" + totalWithdrawn);
        System.out.println("Current Balance  : ₹" + balance);
        System.out.println("Transactions     : " + transactionHistory.size());

        Utils.printLine();
    }

}