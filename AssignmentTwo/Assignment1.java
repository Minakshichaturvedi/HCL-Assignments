import java.util.*;

interface Banking {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

interface Customer {
    void setCustomer(String name, String id);
    String getCustomerDetails();
}

class InvalidAmountException extends RuntimeException {
    InvalidAmountException(String m) { super(m); }
}

class InsufficientFundsException extends RuntimeException {
    InsufficientFundsException(String m) { super(m); }
}

class BankAccount implements Banking, Customer {
    private String name;
    private String id;
    private double balance;

    public void setCustomer(String name, String id) {
        if (name == null || name.isBlank() || id == null || id.isBlank()) throw new IllegalArgumentException("Invalid customer");
        this.name = name;
        this.id = id;
    }

    public String getCustomerDetails() {
        return name + " (" + id + ")";
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new InvalidAmountException("Invalid amount");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new InvalidAmountException("Invalid amount");
        if (amount > balance) throw new InsufficientFundsException("Insufficient funds");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount();
        try {
            acc.setCustomer(sc.nextLine(), sc.nextLine());
            acc.deposit(Double.parseDouble(sc.nextLine()));
            acc.withdraw(Double.parseDouble(sc.nextLine()));
            System.out.println(acc.getCustomerDetails());
            System.out.println(acc.getBalance());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}