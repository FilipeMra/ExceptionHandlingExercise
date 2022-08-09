package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter Account Data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial Balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			double limit = sc.nextDouble();
			System.out.println();

			Account account = new Account(number, holder, balance, limit);

			System.out.println("Enter withdraw amount: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println("New Balance: " + String.format("%.2f", account.getBalance()));
		}

		catch (WithdrawException e) {
			System.out.println(e.getMessage());

		} catch (RuntimeException e) {
			System.out.println("Unexpected Error.");
		}

		sc.close();

	}

}
