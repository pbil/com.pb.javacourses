package com.pb.javacourses._7.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Sender {

	private String host;
	private int port;

	Sender(String host, int port) {
		this.host = host;
		this.port = port;
	}

	private void sendMessage(String mes) {
		try {
			byte[] data = mes.getBytes();
			InetAddress addr = InetAddress.getByName(host);
			DatagramPacket pack = new DatagramPacket(data, data.length, addr, port);
			DatagramSocket ds = new DatagramSocket();
			ds.send(pack);
			ds.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static void main(String[] args) {
		Sender sndr = new Sender("localhost", 1050);
		for (int k = 0; k < args.length; k++)
			sndr.sendMessage(args[k]);
	}
	
}
