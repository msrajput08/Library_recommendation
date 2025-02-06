package com.intern.Final.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Scanner;


public class AddBook {
	private static String BookName;
	private static String Author;
	private static Scanner sc=new Scanner(System.in);
	
	public static void admin() {
		System.out.println("Enter Your Username :- ");
		String Username=sc.nextLine();
//		sc.nextLine();
		System.out.println("Enter Your Password :- ");
		String Password=sc.nextLine();
		sc.nextLine();
		if(Username.equals("Admin")&&Password.equals("root")) {
			add();
		}
		else {
			System.out.println("Access Denied...InValid Credentials");
			return;
		}
	}
	
	public static void add() {
		System.out.println("Enter the Name of The Book :- ");
		BookName=sc.nextLine();
		System.out.println("Enter The Name of The Author :- ");
		Author=sc.nextLine();
		
		try {
		String query="Insert into BookShelf(title,author) values (?,?)";
		Connection con=DBconnection.dbCon();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, BookName);
		ps.setString(2, Author);
		int rs=ps.executeUpdate();
		
		if(rs>0) {
			System.out.println("Book Added Successfully..");
		}
		else {
			System.out.println("Book was Not Added...");
		}
	}
		
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Book was Not Added...");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Book was Not Added...");
		}
}
}
