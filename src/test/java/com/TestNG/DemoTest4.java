package com.TestNG;

import org.testng.annotations.Test;

import com.onlinebanking.GenereicUtils.BaseClass;

public class DemoTest4 {

	@Test(groups="regression")
	public void Demo1()
	{
		System.out.println("===demo41===regression==");
	}
	
	@Test()
	public void Demo2()
	{
		System.out.println("===demo42=====");
	}
}
