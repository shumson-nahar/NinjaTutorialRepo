package com.qa.ninja.utilities;

import java.util.Date;

public class Utilities {
	public static String generatedTimeStamp() {
		Date date = new Date();
		String timeStamp= date.toString().replace(" ", "_").replace(":" ,"_");
		return "seleniumpanda" +  timeStamp +  "@gmail.com";
			

}
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_TIME = 10;
	
}
