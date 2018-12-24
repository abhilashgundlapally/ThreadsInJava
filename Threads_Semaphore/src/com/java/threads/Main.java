package com.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main
{
	public static void main( String[] args ) throws InterruptedException
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for( int i = 0 ; i < 100 ; i++ )
		{
			executor.submit( new Runnable() {
				public void run()
				{
					try
					{
						Connection.getInstance().connect();
					} catch ( InterruptedException e )
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		
		executor.shutdown();
		
		executor.awaitTermination( 1 , TimeUnit.DAYS );
	}
}
