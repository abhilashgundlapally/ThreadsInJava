package com.java.threads;

import java.util.LinkedList;
import java.util.Random;

public class Processor
{
	
	LinkedList<Integer>	list	= new LinkedList<Integer>();
	Object				lock	= new Object();
	
	public Processor( )
	{
		
	}
	
	public void producer( ) throws InterruptedException
	{
		Random rand = new Random();
		while ( true )
		{
			synchronized ( lock )
			{
				while ( list.size() == 10 )
				{
					lock.wait();
				}
				list.add( rand.nextInt( 100 ) );
				lock.notify();
			}
			
		}
		
	}
	
	public void consumer( ) throws InterruptedException
	{
		Random rand = new Random();
		while( true )
		{
			synchronized( lock )
			{
				while( list.size() == 0 )
				{
					lock.wait();
				}
				
				System.out.println(list.removeFirst() + "-size:" + list.size());
				lock.notify();
			}
			Thread.sleep( rand.nextInt(1000));
		}
		
	}
}
