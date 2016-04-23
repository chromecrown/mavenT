package com.xx.test.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/spring/applicationContext.xml",
		"file:src/main/webapp/WEB-INF/config/spring/springMVC-servlet.xml" })
public class TestBase {
	protected Log logger = LogFactory.getLog(TestBase.class);

	/**
	 * some initial code will be here
	 */
	@Before
	public void before() {

	}
	
	@Test
	public void testSome(){
		logger.info("TestBase class method testSome running...");
	}
}