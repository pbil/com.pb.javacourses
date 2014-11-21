package com.pb.javacourses._7.autoclose;

public class FakeResource implements com.pb.javacourses._7.autoclose.AutoCloseable {

	@Override
	public void close() {
		System.out.println("close FakeResource");
	}
	
}
