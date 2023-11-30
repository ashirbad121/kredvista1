package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException  {
		Connection conn=null;
		try
		{
		//register the data base
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection of database
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52", "root", "root");
		
		//create statement
		Statement state = conn.createStatement();
		String query="insert into students values('ABC',7899454,'efffqff',20),('cde',1234,'DAFSGD',22);";
		
		//execute update query
		int result=state.executeUpdate(query);
		
		if(result>=1)
		{
			System.out.println("data entered successfully");
		}
		else
		{
			System.err.println("data not inserted");
		}
		
		}
		catch(Exception e)
		{
			
		}
		finally {
			//close database conn
			conn.close();

		}
				
	}

}
