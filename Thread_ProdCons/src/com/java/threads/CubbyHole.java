package com.java.threads;

public class CubbyHole
{
	private int val;
	private boolean available = false;
	
	public synchronized void put(int i) {
		while(available == true) {
			try
			{
				wait();
			} catch ( InterruptedException e )
			{
				e.printStackTrace();
			}
		}
		val = i;
		available = true;
		notifyAll();
	}
	
	public synchronized int get() {
		while( available == false) {
			try {
				wait();
			}catch ( InterruptedException e )
			{
				e.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return val;
	}
	
}
