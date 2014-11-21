package com.pb.javacourses._7.autoclose;


public class CloseableResource implements java.io.Closeable {

	@Override
	public void close() {
		System.out.println("close CloseableResource");
	}
	
}
