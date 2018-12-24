package com.java.threads;

import java.util.Random;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	private static void producer() throws InterruptedException {
		Random rand = new Random();
		while (true) {
			queue.put(rand.nextInt(100));
		}
	}

	private static void consumer() throws InterruptedException {
		Random rand = new Random();
		while (true) {
			Thread.sleep(100);
			if (rand.nextInt(10) == 0) {
				Integer value = queue.take();
				System.out.println("Queue value : " + value + ":QueueSize : " + queue.size());
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Thread th1 = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread th2 = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
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
