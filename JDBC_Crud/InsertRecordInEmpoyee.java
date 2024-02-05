package com.edu.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecordInEmpoyee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/10426_abhi";
		String un = "root";
		String pass = "Abhishek683";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("enter empid : ");
		int eid = sc.nextInt();
		System.out.print("enter employee name : ");
		String ename = sc.next();
		System.out.print("enter employee salary : ");
		float esal = sc.nextFloat();
		System.out.print("enter employee deptid : ");
		int deptid = sc.nextInt();
		
		
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url,un,pass);
		Statement stmt = conn.createStatement();
		
		String s1 = "select * from employee1 where empid = "+eid+"";
		ResultSet rs = stmt.executeQuery(s1);
		if(rs.next()) {
			System.out.println("id already exists");
		}else {
			//check for foreign key
			String ck = "select * from department where deptid = "+deptid+"";
			ResultSet rk = stmt.executeQuery(ck);
			if(rk.next()) {
				String s = "insert into employee1 values('"+eid+"','"+ename+"','"+esal+"','"+deptid+"')";
				int i = stmt.executeUpdate(s);
				System.out.println(i);
				if(i>0) {
					System.out.println("Record added");
				}else {
					System.out.println("error occured");
				}
			}
			else {
				System.out.println("please entre correct dept_id");
			}
		
		}
		
	}

}
