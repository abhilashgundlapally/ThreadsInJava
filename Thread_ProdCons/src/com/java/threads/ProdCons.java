package com.java.threads;

public class ProdCons
{
	public static void main( String[] args )
	{
		CubbyHole cubyHole = new CubbyHole();
		Producer prod = new Producer(cubyHole);
		Consumer cons = new Consumer(cubyHole);
		Thread th1 = new Thread( new Runnable() {
			public void run() {
				prod.produce();
			}
		});
		Thread t2 = new Thread( new Runnable() {
			public void run() {
				cons.consume();
			}
		});
		
		th1.start();
		t2.start();
		
		try
		{
			th1.join();
			t2.join();
		} catch ( InterruptedException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
