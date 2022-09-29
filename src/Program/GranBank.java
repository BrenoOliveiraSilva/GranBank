package Program;

import java.util.ArrayList;
import java.util.Scanner;

public class GranBank {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Account> bankAccounts;

    public static void main(String[] args) {
        bankAccounts = new ArrayList<Account>();
        operations();
    }

    public static void operations() {
        System.out.println("---------------------------------------");
        System.out.println("----------WELCOME TO GRANBANK----------");
        System.out.println("---------------------------------------");
        System.out.println("-----------SELECT A OPERATION----------");
        System.out.println("---------------------------------------");
        System.out.println("|      OPTION 1 - CREATE ACCOUNT      |");
        System.out.println("|      OPTION 2 - DEPOSIT             |");
        System.out.println("|      OPTION 3 - WITHDRAW            |");
        System.out.println("|      OPTION 4 - TRANSFER            |");
        System.out.println("|      OPTION 5 - LIST                |");
        System.out.println("|      OPTION 6 - EXIT                |");

        System.out.print("\nOPTION: ");
        int operation = input.nextInt();

        switch(operation) {
            case 1:
                createAccount();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                transfer();
                break;
            case 5:
                listAccounts();
                break;
            case 6:
                System.out.println("ENDING PROGRAM!\n");
                System.exit(0);
                break;
            default:
                System.out.println("INVALID OPTION\n");
                operations();
                break;
        }
    }
    //--------------- CREATE ACCOUNT ---------------//
    public static void createAccount() {
        System.out.println("\nName: ");
        String name = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEMAIL: ");
        String email = input.next();
        
        Client client = new Client(name, cpf, email);
        Account account = new Account(client);

        bankAccounts.add(account);
        System.out.println("ACCOUNT CREATED SUCCESFULLY!\n");

        operations();
    }
    //--------------- FIND ACCOUNT ---------------//
    private static Account findAccount(int accountNumber) {
        Account account = null;
        if(bankAccounts.size() > 0) {
            for(Account i: bankAccounts) {
                if(i.getAccountNumber() == accountNumber) {
                    account = i;
                }
            }
        }
        return account;
    }
    //--------------- DEPOSIT ---------------//
    public static void deposit() {
        System.out.println("ACCOUNT NUMBER: ");
        int accountNumber = input.nextInt();

        Account account = findAccount(accountNumber);

        if(account != null) {
            System.out.println("DEPOSIT VALUE: ");
            Double depositValue = input.nextDouble();
            account.deposit(depositValue);
        } else {
            System.out.println("ACCOUNT NOT FOUND!\n");
        }

        operations();
    }
    //--------------- WITHDRAW ---------------//
    public static void withdraw() {
        System.out.println("ACCOUNT NUMBER: ");
        int accountNumber = input.nextInt();

        Account account = findAccount(accountNumber);

        if(account != null) {
            System.out.println("WITHDRAW VALUE: ");
            Double withdrawValue = input.nextDouble();
            account.withdraw(withdrawValue);
        } else {
            System.out.println("ACCOUNT NOT FOUND!\n");
        }

        operations();
    }
    //--------------- TRANSFER ---------------//
    public static void transfer() {
        //--------------- SENDER VERIFICATION ---------------//
        System.out.println("SENDER ACCOUNT NUMBER: ");
        int accountNumberSender = input.nextInt();
        Account accountSender = findAccount(accountNumberSender);
        if(accountSender != null) {
            System.out.println("RECEIVER ACCOUNT NUMBER: ");
            int accountNumberReceiver = input.nextInt();
            Account accountReceiver = findAccount(accountNumberReceiver);
            //--------------- RECEIVER VERIFICATION ---------------//
            if(accountReceiver != null) {
                System.out.println("TRANSFER VALUE: ");
                Double value = input.nextDouble();
                accountSender.transfer(accountReceiver, value);
            } else {
                System.out.println("ACCOUNT NOT FOUND!\n");
            }
        } else {
            System.out.println("ACCOUNT NOT FOUND!\n");
        }
        operations();
    }
    //--------------- LIST ACCOUNTS ---------------//
    public static void listAccounts() {
        if(bankAccounts.size() > 0) {
            for(Account account: bankAccounts) {
                System.out.println(account);
            }
        } else {
            System.out.println("WITHOUT REGISTERED ACCOUNTS!\n");
        }
        operations();
    }
}
