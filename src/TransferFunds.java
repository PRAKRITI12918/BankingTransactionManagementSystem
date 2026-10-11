import java.util.Scanner;

public class TransferFunds {

    public static void run(Scanner sc, Bank bank) {

        try {
            System.out.print("Enter your customer name: ");
            String senderName = sc.nextLine().trim();

            Account sender = bank.findAccount(senderName);

            System.out.println("Current account details:");
            sender.displayDetails();

            System.out.print("Enter receiver customer name: ");
            String receiverName = sc.nextLine().trim();

            Account receiver = bank.findAccount(receiverName);

            if (sender == receiver) {
                throw new TransferFailedException(
                        "Cannot transfer money to the same account.");
            }

            System.out.print("Enter transfer amount: ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                throw new InvalidAmountException(
                        "No transfer amount was entered.");
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
                        "Transfer amount must be greater than zero.");
            }

            if (amount > sender.getBalance()) {
                throw new InsufficientBalanceException(
                        "Insufficient balance for this transfer.");
            }

            System.out.print("Enter your account PIN: ");
            int enteredPin = Integer.parseInt(sc.nextLine());

            if (!sender.checkPin(enteredPin)) {
                throw new TransferFailedException(
                        "Incorrect PIN. Transfer failed.");
            }

            // Update balances only after all checks pass.
            sender.withdraw(amount);
            receiver.deposit(amount);

            System.out.println("Transfer completed successfully!");
            System.out.println("From Account: "
                    + sender.getAccountNumber());
            System.out.println("To Account: "
                    + receiver.getAccountNumber());
            System.out.println("Transferred Amount: " + amount);
            System.out.println("Sender's Remaining Balance: "
                    + sender.getBalance());
            System.out.println("Receiver's Updated Balance: "
                    + receiver.getBalance());

        } catch (AccountNotFoundException |
                 InvalidAmountException |
                 InsufficientBalanceException |
                 TransferFailedException e) {
            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid PIN.");
        }
    }
}
