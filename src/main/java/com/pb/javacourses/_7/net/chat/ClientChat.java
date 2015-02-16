package com.pb.javacourses._7.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

public class ClientChat /*extends Thread*/{

	Socket s;
	PrintWriter socketWriter;
	BufferedReader socketReader;
	BufferedReader consoleReader;
	ServerChat server;
	
	String login;
	


	
	public ClientChat(String host, String port, String login) throws IOException {
		this.login = login;
		s = new Socket(host, Integer.valueOf(port));
		socketWriter = new PrintWriter(s.getOutputStream(), true);
		socketReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		socketWriter.println("connect as " + login);
		
		new Thread() {
			@Override
			public void run() {
				try {
					while(true) {
						String newLine;
						while((newLine = socketReader.readLine()) != null)
							System.out.println(newLine);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();

	
		new Thread() {
			@Override
			public void run() {
				try {
					while(true) {
						socketWriter.println(consoleReader.readLine());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();

	}
	
	
}
