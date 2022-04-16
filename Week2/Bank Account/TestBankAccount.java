public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();


        System.out.println(bankAccount1.getCheckingsBalance());
        bankAccount1.depositMoney(10.00, "checkings");
        System.out.println(bankAccount1.getCheckingsBalance());

        bankAccount1.withdrawMoney(6.00, "checkings");
        System.out.println(bankAccount1.getCheckingsBalance());
        bankAccount1.withdrawMoney(6.00, "checkings");

        bankAccount1.displayAccountBalance();
    }
}