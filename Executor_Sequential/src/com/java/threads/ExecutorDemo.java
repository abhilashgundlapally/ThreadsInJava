package com.java.threads;

public class ExecutorDemo
{
	
	public static void main( String[] args )
	{
		SequentialExecutor seq = new SequentialExecutor();
		
		seq.execute(new RunnableThread("One"));
		seq.execute(new RunnableThread("Two"));
		seq.execute(new RunnableThread("three"));
		
	}
	
}




