import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: Rs" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: Rs" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter withdrawal amount: Rs");
                account.withdraw(scanner.nextDouble());
            } else if (choice == 2) {
                System.out.print("Enter deposit amount: Rs");
                account.deposit(scanner.nextDouble());
            } else if (choice == 3) {
                System.out.println("Current balance: Rs" + account.getBalance());
            } else if (choice == 4) {
                System.out.println("Exiting ATM.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}

public class codsoft_taskno3 {
    public static void main(String[] args) {
        ATM atm = new ATM(new BankAccount(10000));
        atm.start();
    }
}
