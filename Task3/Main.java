package Task3;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("Jane", "Simmons");
        bank.addCustomer("Owen", "Bryant");
        System.out.println("Number of customers: " + bank.getNumOfCustomers());

        bank.getCustomer(0).setAccount(new Account(500.00));
        bank.getCustomer(0).setAccount(new Account(100.00));
        bank.getCustomer(1).setAccount(new Account(250.00));

        Customer c = bank.getCustomer(0);
        Account a = c.getAccount(0);
        System.out.println(c.getFirstName() + " " + c.getLastName()
                + " has " + c.getNumOfAccounts() + " accounts");
        System.out.println("Balance: " + a.getBalance());

        System.out.println("Deposit 150: " + a.deposit(150));
        System.out.println("Balance: " + a.getBalance());

        System.out.println("Withdraw 1000: " + a.withdraw(1000));
        System.out.println("Balance: " + a.getBalance());

        System.out.println("Withdraw 200: " + a.withdraw(200));
        System.out.println("Balance: " + a.getBalance());

        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            Customer cust = bank.getCustomer(i);
            System.out.println(cust.getFirstName() + " " + cust.getLastName()
                    + " - first account balance: " + cust.getAccount(0).getBalance());
        }
    }
}