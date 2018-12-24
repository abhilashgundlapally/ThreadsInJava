package com.java.threads;

public class Main {

	private int count; //volatile is useless 
								//problem is different
	
	public synchronized void increment()
	{
		count++;
	}
	
	public Main(int count) {
		count = 0;
	}

	public void doWork()
	{
		Thread th1 = new Thread( new Runnable() {
			public void run()
			{
				int i = 0;
				while( i++ < 1000)
					increment();
			}
		});
		Thread th2 = new Thread( new Runnable() {
			public void run()
			{
				int i = 0;
				while( i++ < 1000)
					increment();
			}
		});
		
		th1.start();
		th2.start();
		
		try	{
			th1.join();
			th2.join();
			
		}
		catch( InterruptedException e )
		{
			e.printStackTrace();
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		Main app = new Main(0);
		app.doWork();
	}
}
