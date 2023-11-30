package com.TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertion {

	@Test
	public void softassert()
	{
		SoftAssert sa=new SoftAssert();
		
		System.out.println("---1-----");
		System.out.println("---2-----");
		//sa.assertEquals("hello", "helo");
		System.out.println("---3-----");
		sa.assertAll();

		System.out.println("---1-----");
	}
}
