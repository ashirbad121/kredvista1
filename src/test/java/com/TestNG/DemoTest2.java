package com.TestNG;

import org.testng.annotations.Test;

import com.onlinebanking.GenereicUtils.BaseClass;

public class DemoTest2 {

	@Test(groups={"regression","smoke"})
	public void Demo3()
	{
		System.out.println("===demo21====regression==smoke=");
	}
	
	@Test(groups="smoke")
	public void Demo4()
	{
		System.out.println("===demo22===smoke=====");
	}
}
