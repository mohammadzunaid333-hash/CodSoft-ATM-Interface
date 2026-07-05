import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccount(String accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {

                return account;

            }

        }

        return null;

    }

    public void showAllAccounts() {

        Utils.printTitle("ALL BANK ACCOUNTS");

        if (accounts.isEmpty()) {

            Utils.printError("No Accounts Found.");

            return;

        }

        for (BankAccount account : accounts) {

            System.out.println("--------------------------------------");

            System.out.println("Account Number : " +
                    account.getAccountNumber());

            System.out.println("Holder Name    : " +
                    account.getAccountHolderName());

            System.out.println("Account Type   : " +
                    account.getAccountType());

            System.out.println("Balance        : ₹" +
                    account.getBalance());

        }

        Utils.printLine();

    }

    public boolean transferMoney(String from,
                                 String to,
                                 double amount) {

        BankAccount sender =
                findAccount(from);

        BankAccount receiver =
                findAccount(to);

        if (sender == null || receiver == null) {

            Utils.printError("Account Not Found.");

            return false;

        }

        if (sender.getBalance() < amount) {

            Utils.printError("Insufficient Balance.");

            return false;

        }

        sender.withdraw(amount);

        receiver.deposit(amount);

        Utils.printSuccess("Money Transfer Successful.");

        return true;

    }

    public int totalAccounts() {

        return accounts.size();

    }
    public java.util.ArrayList<BankAccount> getAccounts() {
    return accounts;
}

}
