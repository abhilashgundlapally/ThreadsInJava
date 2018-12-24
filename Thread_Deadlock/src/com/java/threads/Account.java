package com.java.threads;

public class Account
{
	private int amount = 1000;
	
	public void deposit( int amount )
	{
		this.amount = this.amount + amount;
	}
	
	public void withdraw( int amount )
	{
		this.amount = this.amount - amount;
	}
	
	public int getBalance( )
	{
		return this.amount;
	}
	
	public static void transfer( Account account1, Account account2, int amount )
	{
		account1.withdraw(amount);
		account2.deposit(amount);
	}
}
