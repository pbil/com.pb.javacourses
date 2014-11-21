package com.pb.javacourses._7.concurrent;

import java.util.concurrent.Phaser;

public class FBIEasterEgg {

	static int lines = 10;
	static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	static StringBuffer randomAlphabet = new StringBuffer();

	public static void main(String[] args) {

		final Phaser phaser = new Phaser() {
			protected boolean onAdvance(int phase, int parties) {
				System.out.println(randomAlphabet);
				randomAlphabet = new StringBuffer();
				return phase >= lines; // loop count managing here
			}
		};

		// everyone have to wait for the main thread
		phaser.register();

		for (int i = 0; i < alphabet.length(); i++) {

			final char next = alphabet.charAt(i);
			phaser.register(); // ticket for the following thread

			new Thread() {
				public void run() {
					do {
						randomAlphabet.append(next);
						phaser.arriveAndAwaitAdvance(); // checkout
					} while (!phaser.isTerminated());
				}
			}.start();
		}

		System.out.println("Write this by hand and carry in the pocket:");
		// some additional preparations may be done here
		// release
		phaser.arriveAndDeregister();
	}
}