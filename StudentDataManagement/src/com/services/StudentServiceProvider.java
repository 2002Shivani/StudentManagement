package com.services;

import java.sql.Connection;


import com.dao.StudentDataBase;

public class StudentServiceProvider {



	public void read(Connection connection) throws Exception {
		StudentDataBase s = new StudentDataBase();
		s.readStudentData(connection);
	

	}

	public void delete( Connection connection) throws Exception {
		StudentDataBase s = new StudentDataBase();
		s.deleteStudentData(connection);
		System.out.println("------------Data Deleted---------------");
	}

	public void update( Connection connection) throws Exception {
		StudentDataBase s = new StudentDataBase();
		s.updateStudentData(connection);
		System.out.println("------------Data Updated---------------");

	}

	public void insert(Connection connection) throws Exception {
		StudentDataBase s = new StudentDataBase();
		s.insertStudentData(connection);
		System.out.println("------------Data Inserted---------------");
	}

}
