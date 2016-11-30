package com.xx.test.base;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"file:src/main/webapp/WEB-INF/config/spring/applicationContext*.xml"
		//"file:src/main/webapp/WEB-INF/config/spring/springMVC-servlet.xml"
		})
public class TestBase {

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