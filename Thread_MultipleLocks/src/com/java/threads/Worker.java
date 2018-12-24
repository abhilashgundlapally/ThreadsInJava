package com.java.threads;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Worker {

	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();

	Object lock1 = new Object();
	Object lock2 = new Object();

	public void doWork1() {
		synchronized (lock1) {
			Random rand = new Random();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list1.add(rand.nextInt(100));
		}
	}

	public void doWork2() {
		synchronized(lock2)
		{
			Random rand = new Random();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list2.add(rand.nextInt(100));

		}
	}

	public void process() {
		int i = 0;
		while (i++ < 1000) {
			doWork1();
			doWork2();
		}
	}

	public void main() throws InterruptedException {
		long beg = System.currentTimeMillis();

		Thread th1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		Thread th2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		th1.start();
		th2.start();

		th1.join();
		th2.join();

		long end = System.currentTimeMillis();

		System.out.println(end - beg);

		System.out.println("list1 : " + list1.size() + ":list2:" + list2.size());
	}
}
