import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit Failed: Amount must be greater than zero");
            return;
        }
        balance = balance + amount;
        System.out.println("Deposit Successful");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal Failed: Amount must be greater than zero");
            return;
        }
        if (amount > balance) {
            System.out.println("Withdrawal Failed: Insufficient Balance");
            return;
        }
        balance = balance - amount;
        System.out.println("Withdrawal Successful");
    }

    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    public double getBalance() {
        return balance;
    }
}

public class P07{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        try {
            BankAccount account = new BankAccount(name, accNo, initialBalance);

            System.out.print("Enter Deposit Amount: ");
            double depositAmount = sc.nextDouble();
            System.out.print("Enter Withdrawal Amount: ");
            double withdrawAmount = sc.nextDouble();

            System.out.println();
            account.displayAccountDetails();

            account.deposit(depositAmount);
            account.withdraw(withdrawAmount);

            System.out.println("Final Balance: " + account.getBalance());

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }

        sc.close();
    }
}