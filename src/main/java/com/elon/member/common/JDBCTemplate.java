package com.elon.member.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "HYUNGJDBC";
	private final String PASSWORD = "HYUNGJDBC";
	
	private static JDBCTemplate instance;
	
	private JDBCTemplate() {}
	
	public static JDBCTemplate getInstance() {
		if(instance == null) { // 객체를 재사용하기위한 싱글톤패턴
			instance = new JDBCTemplate();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
