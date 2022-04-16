public class BankAccount {
    
    private double checkingsBalance;
    private double savingsBalance;


    public static int numOfAccounts = 0;
    public static double totalMoney = 0.0;

    public BankAccount() {
        BankAccount.numOfAccounts += 1;
        this.checkingsBalance = 0.0;
        this.savingsBalance = 0.0;
    }

    public double getCheckingsBalance() {
        return this.checkingsBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
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