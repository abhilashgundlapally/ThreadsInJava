package com.java.threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Processor
{
	Account account1 = new Account();
	Account account2 = new Account();
	
	Lock lock1  = new ReentrantLock();
	Lock lock2  = new ReentrantLock();
	
	private void acquireLocks ( Lock firstLock , Lock secondLock ) throws InterruptedException
	{
		boolean tryFirstLock = false;
		boolean trySecondLock = false;
		
		try
		{
			tryFirstLock = firstLock.tryLock();
			trySecondLock = secondLock.tryLock();
		}finally
		{
			if( tryFirstLock && trySecondLock )
				return ;
			if( tryFirstLock)
				firstLock.unlock();
			if( trySecondLock )
				secondLock.unlock();
		}
	}
	
	public void firstThread( ) throws InterruptedException
	{
		Random rand = new Random();
		for( int i =0; i < 1000 ; i++)
		{
//			lock1.lock();
//			lock2.lock();
			acquireLocks( lock1,lock2);
			try
			{
				Account.transfer( account1 , account2 , rand.nextInt(100) );
			
			}finally
			{
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void secondThread( ) throws InterruptedException
	{
		Random rand = new Random();
		for( int i =0; i < 1000 ; i++)
		{
			acquireLocks( lock1,lock2);
			try
			{
				Account.transfer( account2 , account1 , rand.nextInt(100) );
				
			}finally
			{
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finished( )
	{
		System.out.println("Account 1 balance : " + account1.getBalance());
		System.out.println("Account 2 balance : " + account2.getBalance());
		System.out.println("total balance : " + ( account1.getBalance() + account2.getBalance() ) );
	}
	
}
