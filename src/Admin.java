public class Admin {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static boolean login() {

        Utils.printTitle("ADMIN LOGIN");

        String username =
                InputValidator.getString("Username : ");

        String password =
                InputValidator.getString("Password : ");

        if (username.equals(USERNAME) &&
                password.equals(PASSWORD)) {

            Utils.printSuccess("Admin Login Successful.");

            return true;

        }

        Utils.printError("Invalid Admin Credentials.");

        return false;

    }

    public static void menu(Bank bank) {

        while (true) {

            Utils.printTitle("ADMIN PANEL");

            System.out.println("1. View All Accounts");
            System.out.println("2. Total Accounts");
            System.out.println("3. Total Bank Balance");
            System.out.println("4. Exit");

            Utils.printLine();

            int choice =
                    InputValidator.getInt("Enter Choice : ");

            switch (choice) {

                case 1:

                    bank.showAllAccounts();

                    break;

                case 2:

                    System.out.println(
                            "Total Accounts : "
                                    + bank.totalAccounts());

                    break;

                case 3:

                    double total = 0;

                    for (BankAccount account :
                            bank.getAccounts()) {

                        total += account.getBalance();

                    }

                    System.out.println(
                            "Total Bank Balance : ₹"
                                    + total);

                    break;

                case 4:

                    return;

                default:

                    Utils.printError("Invalid Choice.");

            }

        }

    }

}
