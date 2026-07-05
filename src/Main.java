public class Main {

    public static void main(String[] args) {

        Utils.welcomeScreen();

        Utils.loadingAnimation();

        Bank bank = new Bank();

        // ==========================
        // Demo Account 1
        // ==========================

        BankAccount account1 = new BankAccount(
                "1001001001",
                "Zunaid Mohammad",
                "Savings",
                "SBIN0001234",
                "Tirupati Branch",
                1234,
                50000
        );

        // ==========================
        // Demo Account 2
        // ==========================

        BankAccount account2 = new BankAccount(
                "1001001002",
                "Rahul Sharma",
                "Current",
                "HDFC0005678",
                "Hyderabad Branch",
                4321,
                25000
        );

        // ==========================
        // Demo Account 3
        // ==========================

        BankAccount account3 = new BankAccount(
                "1001001003",
                "Mohammed Ali",
                "Savings",
                "ICIC0007890",
                "Bangalore Branch",
                1111,
                100000
        );

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        FileManager.saveAccount(account1);
        FileManager.saveAccount(account2);
        FileManager.saveAccount(account3);

        ATM atm = new ATM(bank);

        atm.start();

        Utils.goodbyeScreen();

    }

}