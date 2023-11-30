package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraTest {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		String projName="TY_KredVista_100222";
		String createdBy="Ashirbad";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Thread.sleep(25000);
		
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//sign in into RMGYantra
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		//driver.findElement(By.xpath("//label[.='Username']")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		//driver.findElement(By.xpath("//label[.='Password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		//create project
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projName);
		driver.findElement(By.name("createdBy")).sendKeys(createdBy);
		WebElement statusDropdown = driver.findElement(By.name("status"));
		
		Select select=new Select(statusDropdown);
		select.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		
		//resgiter the driver
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		
		//create conn of database
		Connection conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		//create statement
		Statement statement = conn.createStatement();
		//execute query
		String query="select * from project;";
		ResultSet result = statement.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
		
		if(result.getString(4).equals(projName) && result.getString(2).equals(createdBy))
		{
			System.out.println("Assertion success");
			flag=true;
			break;
		}
		
		}
		if(flag==false)
		{
			System.err.println("Assertion failed");
		}
		

	}

}
