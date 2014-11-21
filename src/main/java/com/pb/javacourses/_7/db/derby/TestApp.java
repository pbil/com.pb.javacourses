package com.pb.javacourses._7.db.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author pavel
 * 
 */
public class TestApp {

	private static final String DB_LOCATION = "../TestDb";
	public final static int INT_WITH_UNDERSCORES = 100_00_0_______________00_0;
	public final static int BINARY_INT = 0b001100;
	
	public static void main(String[] args) {
		Connection con = null;
		try {
			try (Connection d = DriverManager.getConnection("jdbc:derby:" + DB_LOCATION + ";create=true")){
				con = d;
				System.out.println(con.isClosed());
			}
			
			System.out.println(con.isClosed());
			try {
				con = DriverManager.getConnection("jdbc:derby:../TestDb;create=true");
				con.close();
//			con = connection;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection("jdbc:derby:../TestDb");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(con.isClosed());
//			con.close();
//			Thread.sleep(10000);
//			System.out.println(con.isClosed());
//			try {
//				DriverManager.getConnection("jdbc:derby:;shutdown=true");
//			} catch (SQLException se) {
//				if (((se.getErrorCode() == 50000) && ("XJ015".equals(se.getSQLState())))) {
//					System.out.println("Derby shut down normally");
//				} else {
//					System.err.println("Derby did not shut down normally");
//					se.printStackTrace();
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println(con.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}