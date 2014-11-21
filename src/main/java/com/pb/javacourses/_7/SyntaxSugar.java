package com.pb.javacourses._7;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.pb.javacourses._7.autoclose.AutoCloseableResource;
import com.pb.javacourses._7.autoclose.CloseableResource;
import com.pb.javacourses._7.autoclose.FakeResource;
import com.pb.javacourses._7.autoclose.NotCloseableResource;
 
/**
 * in git
 * 
 * links:
 * - http://www.oracle.com/technetwork/java/javase/jdk7-relnotes-429209.html
 * - http://www.oracle.com/technetwork/java/javase/jdk7-relnotes-418459.html
 * - http://habrahabr.ru/post/112099/
 * - https://weblogs.java.net/blog/otaviojava/archive/2011/08/11/welcome-java-7-part-1
 * 
 * @author pavel
 * 
 */

public class SyntaxSugar {

	/**
	 * Разделение цифр в числовых литералах подчеркиваниями
	 */
	public final static int INT_WITH_UNDERSCORES = 100_00_0_______________00_0;
	public final static double DOUBLE_WITH_UNDERSCORES = 100_00_0.00_0;
//	public final static double DOUBLE_WITH_UNDERSCOR_2 = 100_00_0_.00_0; // COMPILATION ERROR !
	
	
	/**
	 * Бинарные литералы с префиксом 0b
	 */
	public final static int INT_BINARY_REPRESENTATION_1 = 0b0000000000000000000000000000000000000000000000000000001100;
	public final static int INT_BINARY_REPRESENTATION_2 = 0B0000000000000000000000000000000000000000000000000000001100;
	
	
	/**
	 * При создании обьекта generic класса можно не повторять тип
	 */
	private void genericReplayType() {
		Collection<Integer> nums = new ArrayList<>();
		nums.add(new Integer(12));
		
		Map<String, List<Object>> m = new HashMap<>(); 
//		m.put("good key", "wrong value"); // bad idea
		m.put("good key", new ArrayList<>());
	}
	

	private void autoCloseableInConnection() throws SQLException {
		System.out.println("\nget Connection");
		Connection global = null;
		try (Connection d = DriverManager.getConnection("jdbc:derby:TestDb;create=true")) {
			System.out.println("in try section isClosed: " + d.isClosed());
			global = d;
		} 
		// catch (Exception e) {} // разешается использовать 
		// finally {} // разешается использовать
		System.out.println("after try section isClosed: " + global.isClosed());
	}
	
	
	
	private void autoCloseableInWork() throws SQLException {
//		COMPILATION ERROR!
//		try (NotCloseableResource fr = new NotCloseableResource()) {
//		} 

//		COMPILATION ERROR!
//		try (FakeResource fr = new FakeResource()) {
//		} 
		
		System.out.println("\nget AutoCloseableResource");
		try (AutoCloseableResource acr = new AutoCloseableResource()) {
			System.out.println("work with AutoCloseableResource");
		} 
		
		System.out.println("\nget CloseableResource");
		try (CloseableResource cr = new CloseableResource()) {
			System.out.println("work with CloseableResource");
		}
		
		System.out.println("\nget CloseableResource and AutoCloseableResource");
		try (	CloseableResource cr = new CloseableResource(); 
				AutoCloseableResource acr = new AutoCloseableResource();
//				FakeResource fr = new FakeResource(); -- compilation error
		) {
			System.out.println("work with CloseableResource and AutoCloseableResource");
		}
	}
	
//	public void copyFile(File original, File copy) throws FileNotFoundException, IOException {
//		try (
//		InputStream in = new FileInputStream(original);
//		OutputStream out = new FileOutputStream(copy)) {
//		byte[] buf = new byte[1024];
//		int n;
//		while ((n = in.read(buf)) >= 0) {
//		out.write(buf, 0, n);
//		}
//		}// it is automatically close
//		}
	
	
//	@SafeVarargs
//	static <T> List<T> asList (T... elements) {
//	System.out.println(elements);
//	return null;
//	}
//	@SafeVarargs
//	static void varags(List<String>... stringLists) {
//	Object[] array = stringLists;
//	List<Integer> tmpList = Arrays.asList(42);
//	array[0] = tmpList; //run with warning
//	String s = stringLists[0].get(0); // ClassCastException
//	}
	
	public static void main(String ... args) throws SQLException {
		SyntaxSugar s = new SyntaxSugar();
		s.genericReplayType();
		s.autoCloseableInWork();
		s.autoCloseableInConnection();
	}

	
	  static class FirstException extends Exception { }
	  static class SecondException extends Exception { }
	  static class TException extends Exception { }
	  
	  public void rethrowException(String exceptionName) throws IOException {
	    try {
	      if (exceptionName.equals("First")) {
	        throw new FirstException();
	      } else {
	        throw new SecondException();
	      }
	    } catch (Exception e) {
	      
	    }
	  }
}
