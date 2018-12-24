package com.java.threads;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Processor processor = new Processor();

		Thread th1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread th2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		th1.start();
		th2.start();

		th1.join();
		th2.join();
	}
}
