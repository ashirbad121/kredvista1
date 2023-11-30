package com.TestNG;

import org.testng.annotations.Test;

import com.onlinebanking.GenereicUtils.BaseClass;

public class DemoTest1 {

	@Test(groups="regression")
	public void Demo1()
	{
		System.out.println("===demo11=====regression=====");
	}
	
	@Test()
	public void Demo2()
	{
		System.out.println("===demo12=====");
	}
}
