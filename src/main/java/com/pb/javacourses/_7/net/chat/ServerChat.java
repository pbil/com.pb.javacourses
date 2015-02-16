package com.pb.javacourses._7.net.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerChat extends Thread{

	Integer port;
	ServerSocket sc;
	Collection<Connect> connections = new CopyOnWriteArrayList<Connect>();
	Queue<Message> messages = new ConcurrentLinkedQueue<Message>();
	
	public ServerChat(String port) throws IOException {
		this.port = Integer.valueOf(port);
		this.sc = new ServerSocket(this.port);
		start();
	}
	
	@Override
	public void run() {
		new Thread() {
			@Override
			public void run() {
				try {
					while(true) {
						Socket accept = sc.accept();
						Connect connect = new Connect(accept, ServerChat.this);
						connections.add(connect);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		Message next;
		while(true) {
			next = messages.poll();
			if(next == null)
				continue;
			System.out.println(next.printString());
			for(Connect each : connections) {
				if(!each.login.equals(next.login) )
					each.pw.println(next.printString());
			}
		}
		
	}
	
}
