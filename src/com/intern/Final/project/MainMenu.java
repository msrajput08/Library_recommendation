package com.intern.Final.project;

import java.util.Scanner;

public class MainMenu {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean record=true;
		while(record) {
			System.out.println("\n\n=========Library System========");
			System.out.println("\n1.Add Book in The Library(Admin)");
			System.out.println("2.Register As an User");
			System.out.println("3.Show Available Books");
			System.out.println("4.Borrow Book From The Library");
			System.out.println("5.Show Recommendations");
			System.out.println("6.Exit\n");
			
			System.out.print("Enter Your choice :- ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				AddBook.admin();
				break;
			case 2:
				AddUser.addUser();
				break;
			case 3:
				Show_Books.display();
				break;
			case 4:
				BorrowBooks.BorrowBook();
				break;
			case 5:
				Recommend.recommend();
				break;
			case 6:
				record=false;
				System.out.println("Exiting..");
				break;
			default:
				System.out.println("Invalid Choice Please Try Again...");
			}
		}
			
	}

}
