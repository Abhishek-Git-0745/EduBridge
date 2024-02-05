package com.edu.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecordWithMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String drivers = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/10426_abhi";
		
		String uname = "root";
		
		String pass = "Abhishek683";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name");
		String n = sc.next();
		System.out.println("enter pass");
		String p = sc.next();
		
		Class.forName(drivers);
		
		Connection conn = DriverManager.getConnection(url,uname,pass);
		
		Statement stmt = conn.createStatement();
		
		String r = "select * from login where username='"+n+"'";
		ResultSet rs = stmt.executeQuery(r);
		
		if(rs.next()) {
			System.out.println("name already exists");
		}else {
		String insert = "insert into login values('"+n+"','"+p+"')";
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
