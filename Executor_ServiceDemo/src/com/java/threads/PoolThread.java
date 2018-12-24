package com.java.threads;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread
{
	private BlockingQueue<Runnable> queue;
	private boolean isStopped;

	public PoolThread(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(!this.isStopped) {
			try {
				Runnable run = (Runnable) queue.take();
				run.run();
			} catch ( InterruptedException e )
			{
				//e.printStackTrace();
				//Log
			}
		}
	}
	
	
	public void stopIt() {
		this.isStopped = true;
		this.interrupt();
	}
	
}
