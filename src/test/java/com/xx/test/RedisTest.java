package com.xx.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.xx.test.mt.common.test.TestBase;

public class RedisTest extends TestBase{
	
	protected Log logger = LogFactory.getLog(RedisTest.class);
	
	@Test
	public void connectRedis(){
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void exceptTest(){
		logger.info("this test must throws ArithmeticException");
		int i = 1/0;
	}
}
