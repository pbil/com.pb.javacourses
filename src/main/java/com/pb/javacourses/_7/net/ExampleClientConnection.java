package com.pb.javacourses._7.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ExampleClientConnection {

	public static void main(String... args) {
		connectToSocket();
	}

	private static void connectToSocket() {
		long start = System.nanoTime();
		try {
			System.out.println("start");
			Socket socket = new Socket(InetAddress.getLocalHost(), 8080);
			System.out.println("create socket");
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			System.out.println("connect at: " + start);
			
			String line = br.readLine();
//			while((line = br.readLine()) != null)
				System.out.println(line);

			pw.println("client time: " + start);
			System.out.println("write 1 ");

//			String line = null;
//			String result = "";
//			while ((line = br.readLine()) != null)
//				result = result.concat(line);
			System.out.println(line);
			System.out.println("read 1");
			pw.close();
			br.close();
			socket.close();
//			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
