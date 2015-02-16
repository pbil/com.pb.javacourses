package com.pb.javacourses._7.net.chat;

import java.io.IOException;
/**
 * Run string for server: java -cp . com.pb.javacourses._7.net.chat.ChatApp server 4444 fake
 * Run string for client: java -cp . com.pb.javacourses._7.net.chat.ChatApp client localhost 4444 two
 * 
 * @author pavel
 *
 */
public class ChatApp {

	public static void main(String ... args) {
		try {
			String host = null;
			String port = null;
			String type;
			String login = null;
			if(args.length == 2) {
				port = args[1];
//				login = args[2];
			} else if(args.length == 4) {
				host = args[1];
				port = args[2];
				login = args[3];
			} else {
				System.err.println("Usage: java ChatApp <type server/client> [<host name>] <port number> <login>");
				System.exit(0);
			}
			type = args[0];
			
			if("server".equals(type))
				new ServerChat(port);
			else if("client".equals(type))
				new ClientChat(host, port, login);
			else 
				System.err.println("only 'server' or 'client' as type");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
