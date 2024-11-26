package com.dao;

import java.sql.*;
import java.util.Scanner;

public class StudentDataBase {
	Scanner input = new Scanner(System.in);
	PreparedStatement stmt = null;

	public void insertStudentData(Connection connection) throws Exception {
//		

		System.out.println("How many Entries Do you Want to Add:");
		int n = input.nextInt();
		input.nextLine();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter Name:");
			String name = input.nextLine();
			System.out.println("Enter City:");
			String city = input.nextLine();
			System.out.println("Enter Admission Date(YYYY/MM/DD):");
			String date = input.nextLine();
			System.out.println("Enter Course ID (Ex.JBK1001):");
			String courseId = input.nextLine();
			System.out.println("Enter CGPA:");
			double cgpa = input.nextDouble();
			System.out.println("Enter PRN:");
			long prn = input.nextLong();
			System.out.println("Enter Aadhar Number:");
			long aadhar = input.nextLong();
			input.nextLine();

			this.stmt = connection.prepareStatement(
					"insert into student( name,p_no,city,cgpa,aadharNo,admissionDate,course_enroll )values(?,?,?,?,?,?,?)");
			stmt.setString(1, name);
			stmt.setLong(2, prn);
			stmt.setString(3, city);
			stmt.setDouble(4, cgpa);
			stmt.setLong(5, aadhar);
			stmt.setString(6, date);
			stmt.setString(7, courseId);

			stmt.execute();

		}

	}

	public void updateStudentData(Connection connection) throws Exception {

		System.out.println("You Can Only make  Changes in student  city , cgpa and courseId");
		System.out.println("Enter Name of the student whose data you want to change: ");
		String name = input.nextLine();
		int choice;
		do {
			System.out.println("1:City 2:CGPA 3:courseId 0:Exit\nEnter Choice:");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter New City name");
				String city = input.nextLine();
				stmt = connection.prepareStatement("UPDATE student SET city = (?) WHERE name = (?);");
				stmt.setString(1, city);
				stmt.setString(2, name);
				stmt.executeUpdate();
				break;
			case 2:
				System.out.println("Enter New CGPA name");
				double cgpa = input.nextDouble();
				stmt = connection.prepareStatement("UPDATE student SET cgpa = (?) WHERE name = (?);");
				stmt.setDouble(1, cgpa);
				stmt.setString(2, name);
				stmt.executeUpdate();
				break;
			case 3:
				System.out.println("Enter New CourseID name");
				String c_id = input.nextLine();
				stmt = connection.prepareStatement("UPDATE student SET course_enroll= (?) WHERE name = (?);");
				stmt.setString(1, c_id);
				stmt.setString(2, name);
				stmt.executeUpdate();
				break;
			default:
				System.out.println("Invalid Choice in update");
			}

		} while (choice != 0);

	}

	public void deleteStudentData(Connection connection) throws Exception {
		System.out.println("Enter Name of the student whose data you want to delete: ");
		Long prn = input.nextLong();
		stmt = connection.prepareStatement("DELETE student WHERE p_no = ");
		stmt.setLong(1, prn);
		stmt.executeUpdate();

	}

	public void readStudentData(Connection connection) throws Exception {
		System.out.println("Enter Name of the student whose data you want to read: ");
		String name = input.nextLine();
		stmt = connection.prepareStatement("SELECT * FROM student WHERE name = (?);");
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		System.out.println("-----------------------------------------Data of "+name+"------------------------------------------------");
		System.out.println("id   \t name \t\t p_no \t\t city \t cgpa \t aadharNo \t admissionDate \t course_enroll");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " \t " + rs.getString("name") + " \t " + rs.getLong("p_no") + " \t "
					+ rs.getString("city") + " \t " + rs.getDouble("cgpa") + " \t " + rs.getLong("aadharNo") + " \t "
					+ rs.getString("admissionDate") + " \t " + rs.getString("course_enroll"));
		}
		System.out.println("-------------------------------------------------------------------------------------------------------");

	}

}
