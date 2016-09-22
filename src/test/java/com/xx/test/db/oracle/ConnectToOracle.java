package com.xx.test.db.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectToOracle {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 建表后先commit才能在其它端中调用

			Connection conn = DriverManager.getConnection(url, "ct", "13141591");
			Statement stmt = conn.createStatement(); // 建表时的插入语句记得为' ',而不是" "
			String strSql = "SELECT * FROM test";// 将sql中将;去掉
			ResultSet rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				System.out.println("id:" + rs.getString(1));
				System.out.println("name  :" + rs.getString(2));
				System.out.println("passwd :" + rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
