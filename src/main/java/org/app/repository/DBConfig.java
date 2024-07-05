package org.app.repository;
import java.sql.*;
import java.io.*;
import java.util.*;


public class DBConfig {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private static DBConfig db = null;
	
	private DBConfig(String path)
	{
		try
		{
			FileInputStream fin=new FileInputStream(path);
			Properties properties=new Properties();
			properties.load(fin);
			String className =properties.getProperty("db.driverClassName");
			String uName = properties.getProperty("db.username");
			String pass = properties.getProperty("db.password");
			String url =properties.getProperty("db.url");
			Class.forName(className);
			conn = DriverManager.getConnection(url, uName, pass);		
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
		}
	}
	public static DBConfig getDBInstance(String path) {
		if (db == null) {
				db = new DBConfig(path);
			}
		return db;
	}
	public  Connection getConn() {
		return conn;
	}

	public PreparedStatement getPstmt() {
		return stmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	
	
}
