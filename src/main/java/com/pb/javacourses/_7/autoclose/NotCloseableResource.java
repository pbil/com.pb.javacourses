package com.pb.javacourses._7.autoclose;

public class NotCloseableResource {

	public void close() {
		System.out.println("close FakeResource");
	}
	
}
