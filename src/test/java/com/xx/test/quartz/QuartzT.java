package com.xx.test.quartz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xx.test.mt.scheduler.ScheduleTest;

public class QuartzT {

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
	
	//@Test
	public void testStartSchedule(){
		ScheduleTest schedule = new ScheduleTest();
//		schedule.startSchedule();
		schedule.resumeJob();
	}
}