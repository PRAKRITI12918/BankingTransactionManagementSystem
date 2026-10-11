public class Account {

    private final String customerName;
    private final String accountNumber;
    private final int pin;
    private double balance;

    public Account(String customerName, String accountNumber,
                   int pin, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPin(int enteredPin) {
        return pin == enteredPin;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
