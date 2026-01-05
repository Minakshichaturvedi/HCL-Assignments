import java.util.*;

class Bank {
    String name;
    int accNo;
    double balance;

    // Constructor
    Bank(String name, int accNo) {
        this.name = name;
        this.accNo = accNo;
        this.balance = 0.0; // initial balance
    }

    // Deposit
    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Withdraw
    void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new Exception("Withdrawal amount must be positive!");
            }
            if (amount > balance) {
                throw new Exception("Insufficient balance!");
            }
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Balance enquiry
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Display account details
    void displayDetails() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accNo);
        System.out.println("Balance: " + balance);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        Bank account = new Bank(name, accNo);

        // Menu-driven
        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.displayDetails();
                    break;
                case 5:
                    System.out.println("Thank you for using Bank Management System!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}