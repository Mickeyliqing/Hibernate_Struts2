package com.hibernate.connection.test;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class UserConnectionTest {
public static void main(String[] args) {
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/user?characterEncoding=utf8&&amp;useSSL=true";
	String user = "user";
	String password = "123456";
	
	Connection connection = null;
	try {
		Class.forName(driverName);
		System.out.println("驱动成功");
		connection = (Connection) DriverManager.getConnection(url,user,password);
		System.out.println("连接成功");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
