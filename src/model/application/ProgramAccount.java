package model.application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class ProgramAccount {

	public static void main(String[] args) {
		

			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter account data");
			System.out.print("Number:");
			int number = sc.nextInt();
			System.out.print("Holder:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Initial Balance:");
			double initialBalance = sc.nextDouble();
			System.out.println("Withdraw Limit:");
			double withdrawLimit = sc.nextDouble();
			Account account1 = new Account(number, name, initialBalance, withdrawLimit);
			System.out.println(account1.toString());
			System.out.println("Withdraw amout");
			try {
				
			    account1.whithdraw(sc.nextDouble());
			    System.out.println(account1.toString());

		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Error");
		}
			sc.close();
	}

}
