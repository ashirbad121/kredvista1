package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.graphbuilder.math.func.RandFunction;
import com.mysql.cj.jdbc.Driver;

public class DBpractice2 {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		Random ran=new Random();
		int random=ran.nextInt(100);
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52","root","root");
		Statement statement = conn.createStatement();
		
		System.out.println("enter emp name");
		String name=sc.nextLine();
		int age=random;
		String insertQuery="insert into emp values('"+name+"','"+age+"');";
		//String checkQuery="select * from emp where name='"+name+"';";
		
		// ResultSet set = statement.executeQuery(checkQuery);
		 //if(!(set.next()))
		 {
			 try
			 {
			 int result=statement.executeUpdate(insertQuery);
			 System.out.println("data inserted successfully");
			 }
			 catch(Exception e)
			 {
			 
				 System.out.println("data already exists");
			 }
		 }
		/* else
		 {
			 System.out.println("data already exists");
		 }*/
		conn.close();
		

	}

}
