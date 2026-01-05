import java.io.*;
import java.util.*;

abstract class Account {
    protected String accNo;
    protected String name;
    protected double balance;

    public Account(String accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void displayDetails();

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient Balance");
    }

    public void displayDetails() {
        System.out.println("Savings Account: " + accNo + " " + name + " Balance: " + balance);
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance + 5000) balance -= amount;
        else System.out.println("Limit Exceeded");
    }

    public void displayDetails() {
        System.out.println("Current Account: " + accNo + " " + name + " Balance: " + balance);
    }
}

class Bank {
    private List<Account> accounts = new ArrayList<>();
    private final String file = "bankdata.txt";

    public void addAccount(Account acc) {
        accounts.add(acc);
        saveData();
    }

    public Account findAccount(String accNo) {
        for (Account a : accounts) if (a.accNo.equals(accNo)) return a;
        return null;
    }

    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(new ArrayList<>(accounts));
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            accounts = (List<Account>) ois.readObject();
        } catch (Exception e) {
            accounts = new ArrayList<>();
        }
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        bank.loadData();
        while (true) {
            System.out.println("1 Create Account");
            System.out.println("2 Deposit");
            System.out.println("3 Withdraw");
            System.out.println("4 Balance Enquiry");
            System.out.println("5 Display Details");
            System.out.println("6 Exit");
            int ch = Integer.parseInt(sc.nextLine());
            if (ch == 6) break;
            if (ch == 1) {
                System.out.println("Enter Account No, Name, Balance, Type(S/C)");
                String accNo = sc.nextLine();
                String name = sc.nextLine();
                double bal = Double.parseDouble(sc.nextLine());
                String type = sc.nextLine();
                Account acc = type.equalsIgnoreCase("S") ? new SavingsAccount(accNo, name, bal) : new CurrentAccount(accNo, name, bal);
                bank.addAccount(acc);
            } else {
                System.out.println("Enter Account No");
                String accNo = sc.nextLine();
                Account acc = bank.findAccount(accNo);
                if (acc == null) {
                    System.out.println("Not Found");
                    continue;
                }
                if (ch == 2) {
                    double amt = Double.parseDouble(sc.nextLine());
                    acc.deposit(amt);
                } else if (ch == 3) {
                    double amt = Double.parseDouble(sc.nextLine());
                    acc.withdraw(amt);
                } else if (ch == 4) {
                    System.out.println("Balance: " + acc.getBalance());
                } else if (ch == 5) {
                    acc.displayDetails();
                }
                bank.saveData();
            }
        }
    }
}