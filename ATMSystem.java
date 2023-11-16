import java.util.ArrayList;
import java.util.Scanner;

class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize a user (for demo purposes)
        User user = new User("123456", "7890", "John Doe");

        // Prompt user for login
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Validate login credentials
        if (user.authenticate(userId, pin)) {
            System.out.println("Login successful. Welcome, " + user.getName() + "!\n");

            // Initialize ATM functionalities
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        user.displayTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        user.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        user.deposit(depositAmount);
                        break;
                    case 4:
                        // Implement transfer functionality
                        System.out.println("Transfer functionality not implemented in this demo.");
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid login credentials. Exiting...");
        }
    }
}

class User {
    private String userId;
    private String pin;
    private String name;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public User(String userId, String pin, String name) {
        this.userId = userId;
        this.pin = pin;
        this.name = name;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String userId, String pin) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for " + name + ":");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println();
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            Transaction withdrawalTransaction = new Withdrawal(amount);
            transactionHistory.add(withdrawalTransaction);
            System.out.println("Withdrawal successful. Remaining balance: $" + balance + "\n");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance. Please try again.\n");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            Transaction depositTransaction = new Deposit(amount);
            transactionHistory.add(depositTransaction);
            System.out.println("Deposit successful. New balance: $" + balance + "\n");
        } else {
            System.out.println("Invalid deposit amount. Please try again.\n");
        }
    }

    // Getter for name
    public String getName() {
        return name;
    }
}

abstract class Transaction {
    protected double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": $" + amount;
    }
}

class Withdrawal extends Transaction {
    public Withdrawal(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "Withdrawal";
    }
}

class Deposit extends Transaction {
    public Deposit(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "Deposit";
    }
}