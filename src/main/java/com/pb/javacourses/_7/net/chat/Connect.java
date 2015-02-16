package com.pb.javacourses._7.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connect {

	Socket s;
	PrintWriter pw;
	BufferedReader br;
	ServerChat server;
	
	String login;
	
	public Connect(Socket socket, ServerChat serverChat) throws IOException {
		s = socket;
		server = serverChat;
		pw = new PrintWriter(s.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String connectionString = br.readLine();
		if(connectionString.startsWith("connect as "))
			login = connectionString.replace("connect as ", "");
		else {
			System.err.println("fail connect with: '"+connectionString+"'");
			return;
		}
		
		pw.println("hi " + login);
		System.out.println("hi " + login);
		
		new Thread() {
			public void run() {
				try {
					String fromClient;
					while((fromClient = br.readLine()) != null) {
						server.messages.add(new Message(login, fromClient));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}

}
