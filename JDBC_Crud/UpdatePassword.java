package com.edu.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdatePassword {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
				String drivers = "com.mysql.cj.jdbc.Driver";
				
				String url = "jdbc:mysql://localhost:3306/10426_abhi";
				
				String uname = "root";
				
				String pass = "Abhishek683";
				

				String newpass,name;
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("enter name for which you want to change password");
				name = sc.next();
				
				System.out.println("enter new password");
				newpass = sc.next();
				
				Class.forName(drivers);
		Connection conn = DriverManager.getConnection(url,uname,pass);
		
		Statement stmt = conn.createStatement();
		
		
		//check user exists
		//select query
		
		String s = "select * from login where username='"+name+"'";
		ResultSet rs = stmt.executeQuery(s);
		
		if(rs.next()) {
			String supdate = "update login set userpassword='"+newpass+"' where username='"+name+"'";
			
			int i = stmt.executeUpdate(supdate);
			if(i>0) {
				System.out.println("password is updated");
			}else {
				System.out.println("cannot change password");
			}
		}
		
		
		
		
	}

}
