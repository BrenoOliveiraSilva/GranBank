package Program;

import Utility.Utilities;

public class Account {

    private static int accountCounter = 1;

    private Client client;
    private String agencyNumber;
    private int accountNumber;
    private double balance = 0.0;

    //--------------- CONSTRUCTOR ---------------//
    public Account (Client client) {
        this.agencyNumber = "0000";
        this.accountNumber = accountCounter;
        this.client = client;
        accountCounter += 1;
    }

    //--------------- CLIENT INFORMATIONS ---------------//
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    //--------------- AGENCY INFORMATIONS ---------------//
    public String getAgencyNumber() {
        return agencyNumber;
    }
    //--------------- NUMBER INFORMATIONS ---------------//
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    //--------------- BALANCE INFORMATIONS ---------------//
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //--------------- ACCOUNT INFORMATIONS ---------------//
    public String toString() {
        return "\nAccount: " + this.getAgencyNumber() + "-" + this.getAccountNumber() +
                "\nName: " + this.client.getName() +
                "\nCPF: " + this.client.getCpf() +
                "\nEmail: " + this.client.getEmail() +
                "\nBalance: " + Utilities.doubleToString(this.getBalance()) +
                "\n";
    }
    //--------------- DEPOSIT ---------------//
    public void deposit(Double value) {
        if(value > 0) {
            this.balance += value;
            System.out.println("DEPOSIT MADE SUCCESSFULLY!\n");
        } else {
            System.out.println("YOU CAN'T DEPOSIT NEVATIVE VALUES, IF YOU WANT TO WITHDRAW MONEY, TRY THE WITHDRAW OPTION!\n");
        }
    }
    //--------------- WITHDRAW ---------------//
    public void withdraw(Double value) {
        if(value > 0 && this.getBalance()>= value) {
            this.balance -= value;
            System.out.println("WITHDRAW MADE SUCCESSFULLY!\n");
        } else {
            System.out.println("YOU DON'T HAVE SUFFICIENTE BALANCE OR THE VALUE IS INVALID. PLEASE TRY AGAIN!\n");
        }
    }
    //--------------- TRANSFER ---------------//
    public void transfer(Account accountReceiver, Double value) {
        if(value > 0 && this.getBalance() >= value) {
            this.balance -= value;
            accountReceiver.balance = accountReceiver.getBalance() + value;
            System.out.println("TRANSFER MADE SUCCESSFULLY!\n");
        } else {
            System.out.println("UNABLE TO MAKE THE TRANSFER!\n");
        }
    }
}