package com.java.threads;

class RunnableThread implements Runnable{

	private String name;

	public RunnableThread( String name )
	{
		this.name = name;
	}
	
	@Override
	public void run( )
	{
		for ( int i = 0; i < 5; i++ )
		{
			System.out.print(this.name + ":" + i + "\n");
		}
	}
	
}