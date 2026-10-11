import java.util.Scanner;

public class Deposit {

    public static void run(Scanner sc, Bank bank) {

        try {
            System.out.print("Enter customer name: ");
            String name = sc.nextLine().trim();

            Account account = bank.findAccount(name);

            account.displayDetails();

            System.out.print("How much do you want to deposit? ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                throw new InvalidAmountException(
                        "No deposit amount was entered.");
            }

            double amount;

            try {
                amount = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                throw new InvalidAmountException(
                        "Please enter a valid amount.");
            }

            if (amount <= 0) {
                throw new InvalidAmountException(
                        "Deposit amount must be greater than zero.");
            }

            System.out.print("Enter account PIN: ");
            int enteredPin = Integer.parseInt(sc.nextLine());

            if (!account.checkPin(enteredPin)) {
                System.out.println("Incorrect PIN.");
                return;
            }

            account.deposit(amount);

            System.out.println("Amount deposited successfully!");
            System.out.println("Account Number: "
                    + account.getAccountNumber());
            System.out.println("Deposited Amount: " + amount);
            System.out.println("Updated Balance: "
                    + account.getBalance());

        } catch (AccountNotFoundException |
                 InvalidAmountException e) {
            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid PIN.");
        }
    }
}
