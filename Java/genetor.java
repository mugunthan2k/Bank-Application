package com.jdbc.bank;

import java.util.Random;

public class genetor {
	public static long acgenetor()
	{
		 Random random = new Random();
	        long randomNumber = (long) (random.nextDouble() * 1000000000000l);
	        return randomNumber;
	}
	public static int pingenetor()
	{
		 Random random = new Random();
	        int randomNumber =random.nextInt(1000000);
	     return Math.abs(randomNumber);
	}

}
