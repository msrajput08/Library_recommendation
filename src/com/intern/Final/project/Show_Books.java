package com.intern.Final.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Show_Books {
	public static void display() {
		String query="SELECT b.book_id, b.title, b.author " +
                "FROM BookShelf b " +
                "LEFT JOIN borrowing_history bh ON b.book_id = bh.book_id " +
                "WHERE bh.book_id IS NULL";
		try {
		Connection con=DBconnection.dbCon();
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		System.out.println("Available Books Are :");
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
