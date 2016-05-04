package com.xx.test.mt.common.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"file:src/main/webapp/WEB-INF/config/spring/applicationContext*.xml",
		"file:src/main/webapp/WEB-INF/config/spring/springMVC-servlet.xml"
		})
public class TestBase {
	protected Log logger = LogFactory.getLog(TestBase.class);

	/**
	 * some initial code will be here
	 */
	@Before
	public void before() {

	}
	
	/**
	 * do something after test finish
	 */
	@After
	public void teardown(){
		
	}
}