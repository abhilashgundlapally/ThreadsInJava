package com.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool implements Executor
{

	private BlockingQueue<Runnable>   queue;
	private boolean 			isStopped;
	private List<PoolThread>	threads = new ArrayList<>();	
	
	public ThreadPool( int noOfThreads )
	{
		queue = new LinkedBlockingQueue<>();
		for ( int i = 0; i < noOfThreads; i++ )
		{
			threads.add(new PoolThread(queue));
		}
		
		for (Thread thread : threads )
		{
			thread.start();
		}
	}
	
	@Override
	public void execute( Runnable command ) 
	{
		if( isStopped )
			throw new RuntimeException("Thread Pool has been stopeed");
		queue.offer(command);
	}
	
	public void stop() {
		while(true) {
			if( queue.isEmpty()) {
				this.isStopped = true;
				for (PoolThread thread : threads )
				{
					thread.stopIt();
				}
				break;
			}
		}
	}
	
}
