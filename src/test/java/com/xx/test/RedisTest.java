package com.xx.test;

import org.junit.Test;

public class RedisTest{
	
	
	@Test
	public void connectRedis(){
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void exceptTest(){
		System.out.println("this test must throws ArithmeticException");
		int i = 1/0;
	}
}
