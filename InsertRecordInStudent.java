package com.edu.insert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecordInStudent {

	public static void main(String[] args) throws SQLException {
		String driver = "com.mysql.cj.jdbc";
		String url = "jdbc:mysql://localhost:3306/10426_abhi";
		String uname = "root";
		String pass = "Abhishek683";
		
		Connection conn = DriverManager.getConnection(url,uname,pass);
		
		Statement stmt = conn.createStatement();
		
		int id = 0;
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("entre id");
//		int id = sc.nextInt();
		System.out.println("entre name");
		String name = sc.next();
		System.out.println("entre mail");
		String mail = sc.next();
		System.out.println("entre fees");
		float fee = sc.nextFloat();
		System.out.println("entre dateofbirth");
		String dob = sc.next(); //YYYY-MM-DD
		
//		String r = "select * from student where studentid='"+id+"'";
		String r = "select max(studentid)+1 as id from student";
		ResultSet rs = stmt.executeQuery(r);
		
		if(rs.next()) {
//			System.out.println("record with id "+id+" already exists");
			id = rs.getInt("id"); 
//		}else {
		String insert = "insert into student values("+id+",'"+name+"','"+mail+"',"+fee+",'"+dob+"')";
		int i=stmt.executeUpdate(insert);
		
		System.out.println(i);
		if(i>0) {
			System.out.println("Record added");
		}else {
			System.out.println("error occured");
		}
		}
	}

}
