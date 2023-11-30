package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws SQLException {
		
		//register the driver
		Driver driver=new Driver();//user java.mysql.cj.jdbc.driver import statement
		DriverManager.registerDriver(driver);
		
		//get connection of database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52", "root", "root");
		
		//create statement
		Statement state = conn.createStatement();
		String query="select * from students;";
		
		//execute query
		ResultSet result = state.executeQuery(query);//for select clause the o/p will be in terms of set
		
		
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		}
		
		//close database connection
		conn.close();
		
		
		//interfaces used=Connection,Statement,ResultSet
		//classes used=Driver,DriverManager
		//methods used=registerDriver(driver),createStatement(state),executeQuery(query),getConnection(string url,String UN,String pwd)
		//			  =getRow(),getString()	
		
		
		

	}

}
