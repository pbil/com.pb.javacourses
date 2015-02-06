package com.pb.javacourses._7.concurrent;

public class MyRunnable implements Runnable {

	public void run() {

		double calc = 0;

		for (int i = 0; i < 500000; i++) {

			calc += i;

			if (i % 1000 == 0) {

				System.out.println(calc);

			}

		}

	}

	public String getName() {

		return Thread.currentThread().getName();

	}

	public static void main() {

		Thread t[] = new Thread[5];

		for (int i = 0; i < t.length; i++) {

			t[i] = new Thread(new MyRunnable(), "Поток " + i);

			t[i].setPriority(i * 2);

		}

		for (int i = 0; i < t.length; i++) {

			t[i].start();

			System.out.println(t[i].getName() + " Started");

		}

	}

}