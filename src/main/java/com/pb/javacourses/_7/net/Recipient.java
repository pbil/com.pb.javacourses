package com.pb.javacourses._7.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Recipient {

	public static void main(String[] args) {
		try {
			System.out.println("start");
			DatagramSocket ds = new DatagramSocket(1050);
			while (true) {
				System.out.println("iteration");
				DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
				System.out.println("create pack");
				ds.receive(pack);
				System.out.println("receive pack:");
				System.out.println(new String(pack.getData()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}