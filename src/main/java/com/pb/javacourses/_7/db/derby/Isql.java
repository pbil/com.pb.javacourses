package com.pb.javacourses._7.db.derby;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Isql {

	Connection con;
	
	public void run() {
		connect();
		while(true) {
			String query = readLine();
			if(query == null)
				continue;
			execStatement(query);
		}
	}

	private void execStatement(String query) {
		try {
			Statement st = con.createStatement();//.execute(query);
			st.execute(query);
			process(st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void process(Statement stmt) {
		try {
			while (true) {
			    int rowCount = stmt.getUpdateCount();
			    if (rowCount > 0) {
			        //this is an update count
			        System.out.println("Rows changed = " + rowCount);
			        stmt.getMoreResults();
			        continue;
			    }
			    if (rowCount == 0) {
			        // DDL command or 0 updates
			        System.out.println(" No rows changed or statement was DDL command");
			        stmt.getMoreResults();
			        continue;
			    }
			    // if we have gotten this far, we have either a result set
			    // or no more results
			    ResultSet rs = stmt.getResultSet();
			    if (rs != null) {
			        //. . .
			        // use metadata to get info about result set columns
			        while (rs.next()) {
			        	System.out.println("print rs with metadata");
			        }

			        //. . .

			        // process results
			        stmt.getMoreResults();
			        continue;
			    }
			    break;
			    // there are no more results
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("try again");
		}
	}

	private String readLine() {
		BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
		try {
			return bis.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			}
			return null;
		}
	}

	private void connect() {
		try {
			con = getConnection();
		} catch (SQLException e) {
			System.err.println("error while connect to db");
			e.printStackTrace();
		}
	}
	
	public static void main(String ... args) {
		new Isql().run();
	}


	
	private static void close(ResultSet rs, Statement st, Connection c) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:derby:db/db_jic;create=true");
		System.out.println("is auto commit: " + connection.getAutoCommit());
		System.out.println("is closed: " + connection.isClosed());
		return connection;
	}
	
}
