package com.java.threads;

import java.util.concurrent.Semaphore;

public class Connection
{
	private int			connections	= 0;
	private Semaphore	sem			= new Semaphore(10);
	
	private Connection( )
	{
	}
	
	private static class ConnectionHelper
	{
		private final static Connection INSTANCE = new Connection();
	}
	
	public static Connection getInstance( )
	{
		return ConnectionHelper.INSTANCE;
	}
	
	public void connect( ) throws InterruptedException
	{
		try
		{
			sem.acquire();
		} catch ( InterruptedException e )
		{
			e.printStackTrace();
		}
		
		try
		{
			doConnect();
		} finally
		{
			sem.release();
		}
	}
	
	private void doConnect( ) throws InterruptedException
	{
		
		synchronized ( this )
		{
			connections++;
			
			System.out.println("Connections made : " + connections);
		}
		
		try
		{
			Thread.sleep(2000);
		} catch ( InterruptedException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized ( this )
		{
			connections--;
			// System.out.println("Connections released : " + connections );
		}
		
	}
	
}
