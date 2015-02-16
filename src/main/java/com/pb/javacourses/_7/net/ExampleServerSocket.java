package com.pb.javacourses._7.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ExampleServerSocket {

	public static void main(String... args) {
		tcpSocket();
	}

	private static void tcpSocket() {
		try {
			System.out.println("start " + System.currentTimeMillis());
			ServerSocket sr = new ServerSocket(8080);
			System.out.println("create ssocket, listen");
			Socket socket = sr.accept();
			System.out.println("connect");
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			pw.println("current time: " + new Date());
			System.out.println("ok time");

			System.out.println(br.readLine());
			
			pw.println("server bye");
			System.out.println("ok bye");
			
//			String line = null;
//			String result = "";
//			while ((line = br.readLine()) != null)
//				result = result.concat(line);
			
			pw.close();
			br.close();
			socket.close();
//			sr.close();
			System.out.println("close all");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
