package com.java.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main
{

	public static void main( String[] args )
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<Integer> fut = executor.submit( new Callable<Integer>(){

			public Integer call( ) throws Exception
			{
				Random rand = new Random();
				int duration = rand.nextInt(1000);
				
				System.out.println("Thread is running...");
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e )
				{
					e.printStackTrace();
				}
				System.out.println("Destroying thread... ");
				
				return duration;
			}
			
		});
		
		
		
		try {
			System.out.println("Future data " + fut.get());
		}catch(InterruptedException e )
		{
			e.printStackTrace();
		}catch( ExecutionException e )
		{
			e.printStackTrace();
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		}catch(InterruptedException e )
		{
			e.printStackTrace();
		}
	}
	

}
