package com.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{
	public static void main(String []args ) throws InterruptedException
	{
		int nThreads = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(nThreads);
		Runnable task = new Runnable() {
			@Override
			public void run( )
			{
				System.out.print("Thread Name: " + Thread.currentThread().getName() + "\n");
			}
		};
		
		for ( int i = 0; i < 10; i++ )
			service.submit(task);
		
		service.shutdown();
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
	}
}
