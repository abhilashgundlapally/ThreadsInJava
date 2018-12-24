package com.java.threads;

import java.util.Scanner;

public class Processor {

	public Processor() {

	}

	public void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread is running...");
			wait();
			System.out.println("Producer thread is resumed...");
		}
	}

	public void consumer() throws InterruptedException {

		Thread.sleep(1000);
		Scanner sc = new Scanner(System.in);
		synchronized (this) {
			System.out.println("Consumer thread is running");
			sc.nextLine();
			System.out.println("Return key pressed...");
			notify();
			Thread.sleep(1000);
		}
		sc.close();
	}
}
