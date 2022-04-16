import java.util.Random;

public class BankAccount {
    
    private double checkingsBalance;
    private double savingsBalance;
    private int accountNumber;

    private static int generateAccountNumber() {
        Random rand = new Random();
        int randomID = rand.nextInt(1000000000) + 999999999; // random between 0 and 1 billion, so if its like 3000, add 1 billion and its 1 bil 3k, where as if its 1 bil then its 2 bil --> all the numbers fall between 1 bil and 2 bil
        return randomID;
    }

    public static int numOfAccounts = 0;
    public static double totalMoney = 0.0;

    public BankAccount() {
        BankAccount.numOfAccounts += 1;
        this.checkingsBalance = 0.0;
        this.savingsBalance = 0.0;
        this.accountNumber = BankAccount.generateAccountNumber();
    }

    public double getCheckingsBalance() {
        return this.checkingsBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void depositMoney(double amount, String account) {
        if (account == "checkings") {
            checkingsBalance += amount;
        }
        else {
            savingsBalance += amount;
        }
    }

    public void withdrawMoney(double amount, String account) {
        if (account == "checkings") {
            if (amount > checkingsBalance) {
                System.out.println("Sorry. Insufficient funds.");
            }
            else {
                checkingsBalance -= amount;
            }
        }
        else {
            if (amount > savingsBalance) {
                System.out.println("Sorry. Insufficient funds.");
            }
            else {
                savingsBalance -= amount;
            }
        }
    }

    public void displayAccountBalance() {
        System.out.printf("Savings: %.2f, Checkings %.2f", this.savingsBalance, this.checkingsBalance);
    }
}