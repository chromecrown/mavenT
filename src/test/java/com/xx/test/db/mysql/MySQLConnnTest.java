package com.xx.test.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnnTest{
	
	/**
	 * 
	 */
	@Test
	public void testConnection(){
		Connection conn = null;
		String userName = "root";
		String password = "000000";
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
		}catch(Exception e){
			System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
		}finally {
			if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database Connection Terminated");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		}
	}
}
