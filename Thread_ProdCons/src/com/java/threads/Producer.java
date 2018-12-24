package com.java.threads;

public class Producer
{
	private CubbyHole cubyhole;
	
	public Producer(CubbyHole cubyhole) {
		this.cubyhole = cubyhole;
	}
	
	public void produce() {
		int i = 10;
		while(i > 0) {
			cubyhole.put(i);
			System.out.println("Produce :" + i);
			--i;
		}
	}
}
