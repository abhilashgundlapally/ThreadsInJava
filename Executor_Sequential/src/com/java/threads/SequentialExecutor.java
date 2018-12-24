package com.java.threads;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class SequentialExecutor implements Executor
{

	private Queue<Runnable> queue = new ArrayDeque<>(); 
	private Runnable task;
	
	@Override
	public  synchronized void execute( Runnable command )
	{
		queue.offer( new Runnable() {

			@Override
			public void run( )
			{
				try {
					command.run();
				}finally {
					next();
				}
			}
			
		});
		
		if( task == null ) {
			next();
		}
	}
	
	private synchronized void next() {
		if( (task=queue.poll()) != null )
			new Thread(task).start();
	}
	
}
