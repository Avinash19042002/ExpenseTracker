package com.amdocs.assigments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class BankAccountMainWithArray {	
	public static void main(String args[]){
		int counter = 0;
		int transactionCounter = 0;
		Scanner sc = new Scanner(System.in);
		BankAccount accounts[] = new BankAccount[BankInterface.MAX_ACCCOUNT];
		Transaction transactions[] = new Transaction[BankInterface.MAX_ACCCOUNT * 100];
		BankAccount bankAccount = null;
		Transaction transaction = null;
		HashSet<Integer> findaccount = new HashSet<>();

		do {
			System.out.println("");
			System.out.println("1:Create Account");
			System.out.println("2:Display All Accounts");
			System.out.println("3:Find Accounts By Id");
			System.out.println("4:Perform Withdraw");
			System.out.println("5:Perform Deposit");
			System.out.println("6:Display All Transactions");
			System.out.println("7:Branch Wise Balance Summary");
			System.out.println("8:Transaction Status Summary");
			System.out.println("9:Exit");
			System.out.println("Enter Your choice");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					// Accounts to be created
					bankAccount = new BankAccount();
					bankAccount.createAccount();
					accounts[counter] = bankAccount;
					counter++;
					findaccount.add(bankAccount.getId());
					// transactions need to maintain for each operation
					transaction = new Transaction(bankAccount.getId(), "New Account Created for " + bankAccount.getId(), Status.CREATED, new Date());
					transactions[transactionCounter++] = transaction;
					break;
				case 2:
					for (BankAccount acc : accounts)
						if (acc != null) System.out.println(acc);
					break;
				
				case 3:
					System.out.println("Enter Account id to search");
					int id = sc.nextInt();
					boolean flagToFind = false;
					
					for (BankAccount acc : accounts) {
						if (acc != null && acc.getId() == id) {
							System.out.println(acc);
							flagToFind = true;
							break;
						}
					}
					if (!flagToFind)
						System.out.println("Account Not Found");
					break;
					
				case 4:
					System.out.println("Enter Account id to search For Withdraw");
					int idForWithdraw = sc.nextInt();
					
					if (findaccount.contains(idForWithdraw)) {
						BankAccount account = null;
						for (BankAccount acc : accounts)
							if (acc != null && acc.getId() == idForWithdraw) {
								account = acc;
								break;
							}
						
						System.out.println("Enter the amount to withdraw");
						float withdrawAmount = sc.nextFloat();
						account.withdraw(withdrawAmount);
						transaction = new Transaction(account.getId(), "Successfully Withdrawn", Status.WITHDRAW, new Date());
						transactions[transactionCounter++] = transaction;
					} else {
						System.out.println(idForWithdraw + " Account Not Exist");
					}
					break;
				
				case 5:
					System.out.println("Enter your Account id ");
					int idForDeposit = sc.nextInt();
					
					if (findaccount.contains(idForDeposit)) {
						BankAccount account = null;
						for (BankAccount acc : accounts)
							if (acc != null && acc.getId() == idForDeposit) account = acc;
						
						System.out.println("Enter the amount to deposit");
						float depositAmount = sc.nextFloat();
						account.deposit(depositAmount);
						transaction = new Transaction(account.getId(), depositAmount + " has been Successfully deposited", Status.DEPOSIT, new Date());
						transactions[transactionCounter++] = transaction;
					} else {
						System.out.println(idForDeposit + " Account Not Found");
					}
					break;
				
				case 6:
					for (Transaction transact : transactions)
						if (transact != null) System.out.println(transact);
					break;
				
				case 7:
					HashMap<String, Float> accountsBalance = new HashMap<>();
					for (BankAccount account : accounts) {
						if (account == null) continue;
						String branch = account.getBranch();
						if (accountsBalance.containsKey(branch)) {
							accountsBalance.put(branch, accountsBalance.get(branch) + account.getBal());
						} else {
							accountsBalance.put(branch, account.getBal());
						}
					}
					System.out.println("\nBranch Wise Balance summary");
					System.out.println("Branch  Balance");
					for (Map.Entry<String, Float> e : accountsBalance.entrySet()) {
						System.out.println(e.getKey() + " " + e.getValue());
					}
					break;
				
				case 8:
					HashMap<Status, Long> statusCount = new HashMap<>();
					for (Transaction transact : transactions) {
						if (transact == null) continue;
						Status stat = transact.getStatus();
						if (statusCount.containsKey(stat)) {
							statusCount.put(stat, statusCount.get(stat) + 1L);
						} else {
							statusCount.put(stat, 1L);
						}
					}
					System.out.println("\nTransaction Summary according to Status\n");
					for (Map.Entry<Status, Long> e : statusCount.entrySet()) {
						System.out.println(e.getKey() + " " + e.getValue());
					}
					break;
				
				case 9:
					System.exit(0);
			}
		} while (true);
	}
}