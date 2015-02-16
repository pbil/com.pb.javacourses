package com.pb.javacourses._7.net.chat;

public class Message {

	String login;
	String data;

	public Message(String login, String data) {
		super();
		this.login = login;
		this.data = data;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String printString() {
		return login+ ": " + data;
	}

}
