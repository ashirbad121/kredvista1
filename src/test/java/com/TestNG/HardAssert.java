package com.TestNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssert {

	@Test
	public void hardAssert()
	{
		String actual="hello";
		String exp="helo";
		System.out.println("------1------");
		System.out.println("------2------");
		//assertEquals(actual, exp);
		assertEquals(actual, exp,"failed hkgkgkkkg");
		assertTrue(exp.contains(actual));
		System.out.println("------3------");
		System.out.println("------4------");
		System.out.println("------5------");
	}
	
	@Test
	public void hardAssert1()
	{
		String actual="hello";
		String exp="helo";
		System.out.println("------1------");
		System.out.println("------2------");
		
		System.out.println("------3------");
		System.out.println("------4------");
		System.out.println("------5------");
	}
}
