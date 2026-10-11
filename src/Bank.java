import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    public Bank() {
        accounts.add(new Account("Trisova", "666666",
                129180, 10000));

        accounts.add(new Account("Alexandra", "55555",
                129180, 3000));

        accounts.add(new Account("Ignova", "7777777",
                129180, 2000));

        accounts.add(new Account("Vance", "88888888",
                129180, 400));
    }

    public Account findAccount(String customerName)
            throws AccountNotFoundException {

        for (Account account : accounts) {
            if (account.getCustomerName()
                    .equalsIgnoreCase(customerName)) {
                return account;
            }
        }

        throw new AccountNotFoundException(
                "Invalid account number. Please enter the correct name.");
    }

    public void displayAllAccounts() {
        for (Account account : accounts) {
            account.displayDetails();
            System.out.println("------------------");
        }
    }
}
