package com.java.threads.simple;

public class SimpleRunner implements Runnable {
	
	private volatile boolean running;
	
	public SimpleRunner( boolean running )
	{
		this.running = running;
	}
	
	public void run( )
	{
		while(running)
		{
			System.out.println("Am running!");
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException exp )
			{
				System.out.println(exp.getStackTrace());
			}
			
		}
	}
	
	public void shutdown()
	{
		running = false;
	}
}
