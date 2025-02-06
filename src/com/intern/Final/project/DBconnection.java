package com.intern.Final.project;

import java.sql.*;
import java.util.Scanner;


public class DBconnection {
	private static Connection con=null;
	
	private static String Driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/Library";
	private static String username="root";
	private static String Password="";
	public static Connection dbCon() {
	if(con==null) {
	try { 
		Class.forName(Driver);
		con=DriverManager.getConnection(url,username,Password);
//		System.out.println("Connection Sucessful..!!!");	 
	}
	catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	catch(SQLException e) {
		e.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}

	}
	return con;
}
	
	public static void main (String[]args) {
		System.out.println(DBconnection.dbCon());
				
	}
}
