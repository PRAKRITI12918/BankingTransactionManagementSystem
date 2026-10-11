import java.util.Scanner;

public class Withdrawal {

    public static void run(Scanner sc, Bank bank) {

        try {
            System.out.print("Enter customer name: ");
            String name = sc.nextLine().trim();

            Account account = bank.findAccount(name);

            account.displayDetails();

            System.out.print("How much do you want to withdraw? ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                throw new InvalidAmountException(
                        "No withdrawal amount was entered.");
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
                        "Withdrawal amount must be greater than zero.");
            }

            if (amount > account.getBalance()) {
                throw new InsufficientBalanceException(
                        "Insufficient balance in your account.");
            }

            System.out.print("Enter account PIN: ");
            int enteredPin = Integer.parseInt(sc.nextLine());

            if (!account.checkPin(enteredPin)) {
                System.out.println("Incorrect PIN.");
                return;
            }

            account.withdraw(amount);

            System.out.println("Amount withdrawn successfully!");
            System.out.println("Account Number: "
                    + account.getAccountNumber());
            System.out.println("Withdrawn Amount: " + amount);
            System.out.println("Remaining Balance: "
                    + account.getBalance());

        } catch (AccountNotFoundException |
                 InvalidAmountException |
                 InsufficientBalanceException e) {
            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid PIN.");
        }
    }
}
