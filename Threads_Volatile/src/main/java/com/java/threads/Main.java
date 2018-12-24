package com.java.threads;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.java.threads.simple.SimpleRunner;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		SimpleRunner runner = new SimpleRunner(true);

		Thread thread = new Thread(runner);
		thread.start();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		try {
			bf.readLine();
		} catch (IOException io) {
			// System.out.println(io.getMessage());
			io.printStackTrace();
		}

		runner.shutdown();

		try {
			thread.join();
		} catch (InterruptedException exp) {
			// System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
}
