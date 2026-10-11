import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Transfer Funds");

            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {

                case "1":
                    Deposit.run(sc, bank);
                    break;

                case "2":
                    Withdrawal.run(sc, bank);
                    break;

                case "3":
                    TransferFunds.run(sc, bank);
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select 1 to 5.");
            }
        }
    }
}
