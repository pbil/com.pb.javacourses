package com.pb.javacourses._7.autoclose;

public class AutoCloseableResource implements java.lang.AutoCloseable {

	@Override
	public void close() {
		System.out.println("close AutoCloseableResource");
	}
	
}
