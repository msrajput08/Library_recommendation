package com.intern.Final.project;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

public class BorrowBooks {
	private static Scanner sc= new Scanner(System.in);
	public static void BorrowBook() {
		System.out.print("Enter user ID: ");
        int userId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();
        String query="Insert into Borrowing_History(user_id,book_id) values (?,?)";
        try {
		Connection con=DBconnection.dbCon();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, userId);
		ps.setInt(2, bookId);
		int rs=ps.executeUpdate();
		if(rs>0) {
			System.out.println("Book Borrowed Successfully..");
		}
		else {
			System.out.println("Book was Not Borrowed...");
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