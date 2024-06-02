import project.TransactionDetails;
import java.util.*;

class Bank {
	Map<String, Double> cus_Accounts = new HashMap<>();
	Map<Integer, String> cus_Accounts_num = new HashMap<>();
	Stack<TransactionDetails> transactions = new Stack<>();

	Scanner scanner = new Scanner(System.in);

	// adding a customer
	public void addCustomer(int number, String cus_Name, double inital_Bal) {
		cus_Accounts.put(cus_Name, inital_Bal);
		cus_Accounts_num.put(number, cus_Name);
	}

	// remove a coustermer
	public void rem_cos(int number) {
		String name1 = cus_Accounts_num.get(number);
		for (String name2 : cus_Accounts.keySet()) {
			if (name1 == name2) {
				cus_Accounts_num.remove(number);
				cus_Accounts.remove(name1);
				System.out.println(name1 + " customer is remove ");
				break;
			}
		}
		if (name1 == null) {
			System.out.println("customer not found ");
		}
	}

	// amount deposit
	public void deposit(int number) {
		String name1 = cus_Accounts_num.get(number);
		for (String name2 : cus_Accounts.keySet()) {
			if (name1 == name2) {
				System.out.println("customer name :- " + name1);
				System.out.print("\tEnter deposit amount: ");
				double amount = scanner.nextDouble();
				double balance = cus_Accounts.get(name1);
				balance = balance + amount;
				System.out.println("total amount : " + balance);
				cus_Accounts.put(name1, balance);
				transactions.push(new TransactionDetails(name1, "Deposit ", amount));
			}
		}
		if (name1 == null) {
			System.out.println("Costomer not found ");
		}
	}

	// amount withdraw
	public void withdraw(int number) {
		String name1 = cus_Accounts_num.get(number);
		for (String name2 : cus_Accounts.keySet()) {
			if (name1 == name2) {
				System.out.println("customer name :- " + name1);
				System.out.print("\tEnter withdrawal amount: ");
				double amount = scanner.nextDouble();
				double balance = cus_Accounts.get(name1);
				if (amount <= balance) {
					balance = balance - amount;
					System.out.println("total amount : " + balance);
					cus_Accounts.put(name1, balance);
					transactions.push(new TransactionDetails(name1, "Withdraw ", amount));
				} else {
					System.out.println("Insufficient balance.");
				}
			}
		}
		if (name1 == null) {
			System.out.println("costomer not found ");
		}
	}

	// Balance check
	public void checkBalance(int number) {
		String name1 = cus_Accounts_num.get(number);
		for (String name2 : cus_Accounts.keySet()) {
			if (name1 == name2) {
				double balance = cus_Accounts.get(name1);
				System.out.println("total amount : " + balance);
			}
		}
		if (name1 == null) {
			System.out.println("costomer not found ");
		}
	}

	// display all transataion
	public void display(int number) {
		System.out.println("Transaction\t\tAmount");
		String name1 = cus_Accounts_num.get(number);
		for (String name2 : cus_Accounts.keySet()) {
			if (name1 == name2) {
				for (TransactionDetails i : transactions) {
					if (i.name.equals(name1)) {
						System.out.println(i.type + "\t\t" + i.amount);
					}
				}
			}
		}
		if (name1 == null) {
			System.out.println("costomer not found ");
		}
	}

	// display all cous
	public void dis_all() {
		for (int number : cus_Accounts_num.keySet()) {
			String name1 = cus_Accounts_num.get(number);
			for (String name2 : cus_Accounts.keySet()) {
				double amount = cus_Accounts.get(name2);
				if (name1 == name2) {
					System.out.println("Acc_Num : XXXXXXX" + number + "\n\tcustomer name is : " + name1
							+ "\n	Total amount is : " + amount + "\n");
				}
			}
		}
	}

	// remove all coustremers
	public void rem_all() {
		cus_Accounts.clear();
		cus_Accounts_num.clear();
		System.out.println("All cousters are remove ");
	}

	// transfer one acc to another account
	public int another_Acc(int number1, int number2) {

		String name11 = cus_Accounts_num.get(number1);
		String name12 = cus_Accounts_num.get(number2);
		if (name11 == null) {
			System.out.println(" Sender costomer not found ");
			return 0;
		}
		if (name12 == null) {
			System.out.println(" Receiver costomer not found ");
			return 0;
		}

		for (String name2 : cus_Accounts.keySet()) {
			if (name11 == name2) {
				System.out.print("Enter the amount: ");
				double amount = scanner.nextDouble();
				double balance = cus_Accounts.get(name11);
				if (amount <= balance) {
					balance = balance - amount;
					System.out.println("your total amount : " + balance);
					cus_Accounts.put(name11, balance);
					transactions.push(new TransactionDetails(name11, "Transfer to another Acc ", amount));
					System.out.println("Transaction Successfully completed ");

					double balance1 = cus_Accounts.get(name12);
					balance1 = balance1 + amount;
					cus_Accounts.put(name12, balance1);
					transactions.push(new TransactionDetails(name12, "Receive from another Acc ", amount));
				} else {
					System.out.println("Insufficient balance.");
				}
			}
		}
		return 0;
	}
}
