import java.util.Scanner;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid number. Try again.");
            }
        }
    }

    public static double getDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid amount. Try again.");
            }
        }
    }

    public static String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int getPin(String message) {
        while (true) {
            System.out.print(message);
            String pin = scanner.nextLine();

            if (pin.matches("\\d{4}")) {
                return Integer.parseInt(pin);
            }

            System.out.println("PIN must be exactly 4 digits.");
        }
    }
}