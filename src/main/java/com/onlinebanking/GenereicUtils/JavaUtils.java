package com.onlinebanking.GenereicUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	public int getRandomNo()
	{
		Random ran=new Random();
		int num=ran.nextInt(500);
		return num;
	}
	
	public String getSysDate()
	{
		Date date=new Date();
		String systemDate=date.toString();
		return systemDate;	
	}
	public String systemDateInFormat()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date=new Date();
		String systemDateInFormat=dateFormat.format(date);
		return systemDateInFormat;
	}
}
