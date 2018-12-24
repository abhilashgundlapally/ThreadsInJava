package com.java.threads;

public class Consumer
{
	private CubbyHole cbyHole;
	
	public Consumer( CubbyHole cbyHole )
	{
		this.cbyHole = cbyHole;
	}
	
	public void consume( )
	{
		int i = 10;
		while ( i > 0 )
		{
			int val = cbyHole.get();
			System.out.println("Consume :" + val);
			i--;
		}
		
	}
}
