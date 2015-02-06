package com.pb.javacourses._7;

import java.awt.MouseInfo;
import java.awt.Point;

public class MousePosition {
	public static void main(String args[]) throws InterruptedException {
		while (true) {
			Thread.sleep(1000); // some time for user to position mouse
			Point spot = MouseInfo.getPointerInfo().getLocation();
			System.out.println(String.valueOf(spot.getX()) + "," + String.valueOf(spot.getY()));
		}
	}
}