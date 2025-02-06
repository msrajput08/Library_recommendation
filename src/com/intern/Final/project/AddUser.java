package com.intern.Final.project;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddUser {
	private static String UserName;
	
	public static void addUser() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the UserName :- ");
		UserName=sc.nextLine();
		
		String query="Insert into Users(username) values (?)";
		try {
		Connection con=DBconnection.dbCon();
		PreparedStatement ps=con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, UserName);
		int rs=ps.executeUpdate();
		if(rs>0) {
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long userId = generatedKeys.getLong(1);
                    System.out.println("User Added Successfully. User ID: " + userId);
		}
			}
		}
		else {
			System.out.println("User was Not Added...");
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
