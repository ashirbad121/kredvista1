package com.onlinebanking.GenereicUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DBUtils {

	Connection conn=null;
	/**
	 * 
	 * @throws Throwable
	 */
	public void connectDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DB_UN, IpathConstants.DB_PWD);
	}
	/**
	 * This method is used to check if the expected and actual data are same or not
	 * @param colData
	 * @param expData
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public String exceuteAndGetTheData(int colData,String expData,String query) throws Throwable
	{
		Statement state = conn.createStatement();
		//String query="select * from students;";
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			if(result.getString(colData).equals(expData))
			{
				flag=true;
				break;	
				
			}		
		}
		if(flag)
		{
			System.out.println("Actual and expected data matched");
			return expData;
		}
		else
		{
			System.out.println("Data mismatch from actual and expected data");
			return "";
		}
		
	}
	/**
	 * This method is used to disconnect DB
	 * @throws Throwable
	 */
	public void disconnectDB() throws Throwable
	{
		conn.close();
	}
	
}
