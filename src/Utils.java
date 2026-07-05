public class Utils {

    public static void printLine() {
        System.out.println("==============================================================");
    }

    public static void printTitle(String title) {
        printLine();
        System.out.printf("%35s%n", title);
        printLine();
    }

    public static void printSuccess(String message) {
        System.out.println("✅ " + message);
    }

    public static void printError(String message) {
        System.out.println("❌ " + message);
    }

    public static void printInfo(String message) {
        System.out.println("ℹ " + message);
    }

    public static void loadingAnimation() {

        System.out.print("Loading");

        try {

            for (int i = 0; i < 5; i++) {
                Thread.sleep(300);
                System.out.print(".");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println();
    }

   public static void welcomeScreen() {

    printLine();

   System.out.println(" █████╗ ██████╗ ██╗   ██╗ █████╗ ███╗   ██╗ ██████╗███████╗██████╗ ");
System.out.println("██╔══██╗██╔══██╗██║   ██║██╔══██╗████╗  ██║██╔════╝██╔════╝██╔══██╗");
System.out.println("███████║██║  ██║██║   ██║███████║██╔██╗ ██║██║     █████╗  ██║  ██║");
System.out.println("██╔══██║██║  ██║╚██╗ ██╔╝██╔══██║██║╚██╗██║██║     ██╔══╝  ██║  ██║");
System.out.println("██║  ██║██████╔╝ ╚████╔╝ ██║  ██║██║ ╚████║╚██████╗███████╗██████╔╝");
System.out.println("╚═╝  ╚═╝╚═════╝   ╚═══╝  ╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝╚══════╝╚═════╝ ");

System.out.println();

System.out.println(" █████╗ ████████╗███╗   ███╗");
System.out.println("██╔══██╗╚══██╔══╝████╗ ████║");
System.out.println("███████║   ██║   ██╔████╔██║");
System.out.println("██╔══██║   ██║   ██║╚██╔╝██║");
System.out.println("██║  ██║   ██║   ██║ ╚═╝ ██║");
System.out.println("╚═╝  ╚═╝   ╚═╝   ╚═╝     ╚═╝");

System.out.println();

System.out.println("██████╗  █████╗ ███╗   ██╗██╗  ██╗");
System.out.println("██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝");
System.out.println("██████╔╝███████║██╔██╗ ██║█████╔╝ ");
System.out.println("██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ ");
System.out.println("██████╔╝██║  ██║██║ ╚████║██║  ██╗");
System.out.println("╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ");

    System.out.println();
    System.out.println("        ADVANCED BANKING MANAGEMENT SYSTEM");
    System.out.println("      Secure • Fast • Reliable • Java");
    System.out.println();
    System.out.println("      Developed By : Pinjari Mohammed Zunaid");
    System.out.println("      CodSoft Java Internship Project");
    System.out.println();

    printLine();
}

    public static void goodbyeScreen() {

        printLine();
        System.out.println("      Thank You For Using Our ATM");
        System.out.println("           Visit Again 😊");
        printLine();

    }

    public static void pause() {

        System.out.println();
        System.out.println("Press ENTER to continue...");

        try {
            System.in.read();
        } catch (Exception e) {
            // Ignore
        }

    }
}