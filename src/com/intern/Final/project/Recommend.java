package com.intern.Final.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Recommend {
	private static int UserId;
	private static Scanner sc=new Scanner(System.in);
	public static void recommend() {
		System.out.println("Enter UserId :- ");
		UserId=sc.nextInt();
		 sc.nextLine();
		
		 String query = "SELECT b.book_id, b.title, b.author FROM BookShelf b " +
                 "JOIN Borrowing_History bh ON b.book_id = bh.book_id " +
                 "WHERE bh.user_id = ?";
		 try {
			 Connection con=DBconnection.dbCon();
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setInt(1, UserId);
			 ResultSet rs=ps.executeQuery();
			 
			 System.out.println("Recommended Books :- ");
			 while(rs.next()) {
				 int BookId=rs.getInt("book_id");
				 String Title=rs.getString("title");
				 String Author=rs.getString("author");
				 System.out.println("[Book ID: " + BookId + ",\n Title: " + Title + ",\n Author: " + Author+"]");
			 }
			 
		 }
		 catch(SQLException e) {
				e.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

	}
	

}
