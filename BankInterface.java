package com.amdocs.assigments;

public interface BankInterface {
	int MAX_ACCCOUNT=100;
	
	public void withdraw(float amount);
	public void deposit(float amount)throws InsufficientBalanceException;
	public void transfer(BankAccount account,float amount);	
}