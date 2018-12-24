package com.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private int count;
    public Task(int count) {
	this.count = count;
    }

    public void run() {
	System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + count + "." );
    }
}

public class SingleThreadedExecutorMain {

    public static void main(String[] args) {
	ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
	for (int i = 0; i < 10; i++) {
	    singleThreadExecutor.execute(new Task(i));
	}
	
	singleThreadExecutor.shutdown();
	try {
	    singleThreadExecutor.awaitTermination(1, TimeUnit.DAYS);
	} catch (InterruptedException e) {
	    System.out.println("InterruptedExeception Handled.");
	}
	
    }

}
