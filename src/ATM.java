public class ATM {

    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void start() {

        Utils.welcomeScreen();

        while (true) {

            Utils.printTitle("ADVANCED ATM SYSTEM");

            System.out.println("1. Login");
            System.out.println("2. Create New Account");
            System.out.println("3. Show All Accounts");
            System.out.println("4. Search Account");
            System.out.println("5. Transfer Money");
            System.out.println("6. Exit");

            Utils.printLine();

            int choice =
                    InputValidator.getInt("Enter Choice : ");

            switch (choice) {

                case 1:
                    login();
                    break;

                case 2:
                    createAccount();
                    break;

                case 3:
                    bank.showAllAccounts();
                    break;

                case 4:
                    searchAccount();
                    break;

                case 5:
                    transferMoney();
                    break;

                case 6:
                    Utils.goodbyeScreen();
                    return;

                default:
                    Utils.printError("Invalid Choice.");

            }

        }

    }

    private void createAccount() {

        Utils.printTitle("CREATE ACCOUNT");

        String accountNumber =
                InputValidator.getString("Account Number : ");

        String holder =
                InputValidator.getString("Account Holder Name : ");

        String accountType =
                InputValidator.getString("Account Type : ");

        String ifsc =
                InputValidator.getString("IFSC Code : ");

        String branch =
                InputValidator.getString("Branch Name : ");

        int pin =
                InputValidator.getPin("Create 4 Digit PIN : ");

        double openingBalance =
                InputValidator.getDouble("Opening Balance : ₹");

        BankAccount account =
                new BankAccount(
                        accountNumber,
                        holder,
                        accountType,
                        ifsc,
                        branch,
                        pin,
                        openingBalance
                );

        bank.addAccount(account);

        FileManager.saveAccount(account);

        Utils.printSuccess("Account Created Successfully.");

    }
        private void login() {

        Utils.printTitle("LOGIN");

        String accountNumber =
                InputValidator.getString("Enter Account Number : ");

        BankAccount account =
                bank.findAccount(accountNumber);

        if (account == null) {

            Utils.printError("Account Not Found.");

            return;

        }

        int pin =
                InputValidator.getPin("Enter PIN : ");

        if (!account.validatePin(pin)) {

            Utils.printError("Invalid PIN.");

            return;

        }

        Utils.printSuccess("Login Successful.");

        accountMenu(account);

    }

    private void searchAccount() {

        Utils.printTitle("SEARCH ACCOUNT");

        String accountNumber =
                InputValidator.getString("Enter Account Number : ");

        BankAccount account =
                bank.findAccount(accountNumber);

        if (account == null) {

            Utils.printError("Account Not Found.");

            return;

        }

        account.showAccountDetails();

    }

    private void transferMoney() {

        Utils.printTitle("TRANSFER MONEY");

        String sender =
                InputValidator.getString("Sender Account : ");

        String receiver =
                InputValidator.getString("Receiver Account : ");

        double amount =
                InputValidator.getDouble("Amount : ₹");

        bank.transferMoney(sender, receiver, amount);

    }
        private void accountMenu(BankAccount account) {

        while (true) {

            Utils.printTitle("ACCOUNT MENU");

            System.out.println("1. Account Details");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transaction History");
            System.out.println("6. Account Statistics");
            System.out.println("7. Change PIN");
            System.out.println("8. Logout");

            Utils.printLine();

            int choice =
                    InputValidator.getInt("Enter Choice : ");

            switch (choice) {

                case 1:
                    account.showAccountDetails();
                    break;

                case 2:
                    account.checkBalance();
                    break;

                case 3:

                    double deposit =
                            InputValidator.getDouble("Enter Deposit Amount : ₹");

                    account.deposit(deposit);

                    break;

                case 4:

                    double withdraw =
                            InputValidator.getDouble("Enter Withdraw Amount : ₹");

                    account.withdraw(withdraw);

                    break;

                case 5:

                    account.showTransactionHistory();

                    break;

                case 6:

                    account.showStatistics();

                    break;

                case 7:

                    int oldPin =
                            InputValidator.getPin("Current PIN : ");

                    int newPin =
                            InputValidator.getPin("New PIN : ");

                    account.changePin(oldPin, newPin);

                    break;

                case 8:

                    Utils.printSuccess("Logged Out Successfully.");

                    return;

                default:

                    Utils.printError("Invalid Choice.");

            }

        }

    }

}