package com.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.services.StudentServiceProvider;

public class StudentMain {

	public static void main(String[] args) throws Exception {
		StudentServiceProvider provider = new 	StudentServiceProvider();
		Scanner in = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaclass?useSSL=false", "root","root");
		System.out.println("Connection Established");
		
		int choice;
		do {
			System.out.println("1:Read 2:Insert 3:Update 4:Delete 0:Exit\nEnter Choice");
			choice = in.nextInt();
			switch(choice) {
			
			case 1:
				provider.read(connection);
				break;
			case 2: 
				provider.insert(connection);
			case 3:
				provider.update(connection);
				break;
			case 4:
				provider.delete(connection);
				break;
			case 0 : 
				connection.close();
				System.out.println("Exit"); 
				break;
			default : System.out.println("Inavlid Input");
			
			}
			
		}while(choice!=0);
	

	}

}
