package com.TestNG;

import org.testng.annotations.Test;

public class PracticeTestNGTest {

	@Test(dependsOnMethods= "xeleteTest")
	public void createTest()
	{
		System.out.println("--create test----");
	}
	
	@Test(dependsOnMethods ="editTest" )
	public void xeleteTest()
	{
		System.out.println("--delete test----");
	}
	
	@Test
	public void editTest()
	{
		System.out.println("--edit test----");
	}
	
	@Test(dependsOnMethods = "editTest")
	public void ffTest()
	{
		System.out.println("--ff test----");
	}
}
