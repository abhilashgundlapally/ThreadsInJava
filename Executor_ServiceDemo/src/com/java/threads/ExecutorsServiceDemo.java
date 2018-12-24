package com.java.threads;


public class ExecutorsServiceDemo
{
	public static void main( String[] args )
	{
		ThreadPool service = new ThreadPool(Runtime.getRuntime().availableProcessors());
		
		for ( int i = 0; i < 30; i++ )
		{
			service.execute(new Runnable() {
				
				@Override
				public void run( )
				{
					System.out.println("Thread Name " + Thread.currentThread().getName());
				}
			});
		}
		
		service.stop();
	}
}
