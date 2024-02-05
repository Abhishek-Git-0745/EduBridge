package com.edu.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecord {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver ="com.mysql.cj.jdbc.Driver";
		String  url ="jdbc:mysql://localhost:3306/10426_abhi";
		String un="root";
		String pass ="Abhishek683";
		Connection conn = null;
		Statement stmt = null;
		
		//delete record
		String uname;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name to delete from database");
		uname = sc.next();
		
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url,un,pass);
		stmt = conn.createStatement();
		
		//check user exists
		//using select statement
		
		String s = "select * from login where username='"+uname+"'";
		ResultSet rs = stmt.executeQuery(s);
		
		if(rs.next()) {			
			String d = "delete from login where username='"+uname+"'";
			
			int i = stmt.executeUpdate(d);
			if(i>0) {
				System.out.println("record is deleted");
			}		
		}else {
			System.out.println("User not exists cannot delete record");
		}
		
	}

}
