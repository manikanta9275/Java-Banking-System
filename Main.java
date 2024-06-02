import project.Bank;
import project.TransactionDetails;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\t\t--WELCOME--");
        while (true) {
            System.out.println();
            System.out.println("(1) Add Customer  ");
            System.out.print("(2) Deposit  ");
            System.out.print("\t\t\t\t (3) Withdraw   ");
            System.out.print("\t\t(4) Check Balance   ");
            System.out.println("\t(5) Print Transactions    ");
            System.out.print("(6) Display All Customer Details  ");
            System.out.print("\t (7) Remove a Customer	");
            System.out.println("\t(8) Remove a11 Customer  ");
            System.out.println("(9) Customer Acc To Another Customer Acc   ");
            System.out.println("(10)Exit");
            System.out.print("\nSelect an option: ");

            int option = scanner.nextInt();
            String cus_Name;
            switch (option) {
                case 1:
                    int number;
                    do {
                        number = ThreadLocalRandom.current().nextInt(10000, 99999);
                    } while (bank.cus_Accounts_num.containsKey(number));

                    System.out.print("Enter customer Name: ");
                    scanner.nextLine();
                    cus_Name = scanner.nextLine();

                    System.out.print("Initial Balance: ");
                    double inital_Bal = scanner.nextDouble();

                    System.out.println("Account number is :" + "XXXXXXX" + number);
                    bank.addCustomer(number, cus_Name, inital_Bal);
                    System.out.println("----------------------");
                    break;
                case 2:
                    System.out.print("Enter customer Acc_num: ");
                    number = scanner.nextInt();

                    bank.deposit(number);
                    System.out.println("----------------------");
                    break;
                case 3:
                    System.out.print("Enter customer Acc_num: ");
                    number = scanner.nextInt();

                    bank.withdraw(number);
                    System.out.println("----------------------");
                    break;
                case 4:
                    System.out.print("Enter customer Acc_num: ");
                    number = scanner.nextInt();

                    bank.checkBalance(number);
                    System.out.println("----------------------");
                    break;
                case 5:
                    System.out.print("Enter customer Acc_num: ");
                    number = scanner.nextInt();

                    bank.display(number);
                    System.out.println("----------------------");
                    break;
                case 6:
                    bank.dis_all();
                    System.out.println("----------------------");
                    break;
                case 7:
                    System.out.print("Enter customer Acc_num: ");
                    number = scanner.nextInt();

                    bank.rem_cos(number);
                    System.out.println("----------------------");
                    break;
                case 8:
                    bank.rem_all();
                    System.out.println("----------------------");
                    break;
                case 9:
                    System.out.println("We can transfer the amount, for these bank customer account only ");
                    System.out.print("enter your Acc number  : ");
                    int number1 = scanner.nextInt();

                    System.out.println("\t customer name :- " + bank.cus_Accounts_num.get(number1));
                    System.out.print("enter Another customer Acc number  : ");
                    int number2 = scanner.nextInt();
                    System.out.println("\t customer name :- " + bank.cus_Accounts_num.get(number2));

                    bank.another_Acc(number1, number2);
                    System.out.println("----------------------");
                    break;

                case 10:
                    scanner.close();
                    System.err.print("U EXIT");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}